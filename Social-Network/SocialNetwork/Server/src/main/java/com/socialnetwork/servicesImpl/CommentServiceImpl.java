package com.socialnetwork.servicesImpl;

import com.socialnetwork.domain.entities.Comment;
import com.socialnetwork.domain.entities.Post;
import com.socialnetwork.domain.entities.User;
import com.socialnetwork.domain.entities.UserRole;
import com.socialnetwork.domain.models.bindingModels.comment.CommentCreateBindingModel;
import com.socialnetwork.domain.models.serviceModels.CommentServiceModel;
import com.socialnetwork.repositories.CommentRepository;
import com.socialnetwork.repositories.PostRepository;
import com.socialnetwork.repositories.RoleRepository;
import com.socialnetwork.repositories.UserRepository;
import com.socialnetwork.services.CommentService;
import com.socialnetwork.utils.responseHandler.exceptions.CustomException;
import com.socialnetwork.validations.serviceValidation.services.CommentValidationService;
import com.socialnetwork.validations.serviceValidation.services.PostValidationService;
import com.socialnetwork.validations.serviceValidation.services.UserValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import static com.socialnetwork.utils.constants.ResponseMessageConstants.SERVER_ERROR_MESSAGE;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final CommentValidationService commentValidation;
    private final UserValidationService userValidation;
    private final PostValidationService postValidation;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository, RoleRepository roleRepository, ModelMapper modelMapper, CommentValidationService commentValidation, UserValidationService userValidation, PostValidationService postValidation) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.commentValidation = commentValidation;
        this.userValidation = userValidation;
        this.postValidation = postValidation;
    }

    @Override
    public boolean createComment(CommentCreateBindingModel commentCreateBindingModel) throws Exception {
        if (!commentValidation.isValid(commentCreateBindingModel)) {
            throw new Exception(SERVER_ERROR_MESSAGE);
        }

        User creator = this.userRepository
                .findById(commentCreateBindingModel.getLoggedInUserId())
                .orElse(null);

        User timelineUser = this.userRepository
                .findById(commentCreateBindingModel.getTimelineUserId())
                .orElse(null);

        Post post = this.postRepository
                .findById(commentCreateBindingModel.getPostId())
                .orElse(null);

        if (!userValidation.isValid(creator) || !userValidation.isValid(timelineUser) || !postValidation.isValid(post)) {
            throw new Exception(SERVER_ERROR_MESSAGE);
        }

        CommentServiceModel commentServiceModel = new CommentServiceModel();
        commentServiceModel.setPost(post);
        commentServiceModel.setCreator(creator);
        commentServiceModel.setTimelineUser(timelineUser);
        commentServiceModel.setContent(commentCreateBindingModel.getContent());
        commentServiceModel.setTime(LocalDateTime.now());
        commentServiceModel.setImageUrl(commentCreateBindingModel.getImageUrl());

        Comment comment = this.modelMapper.map(commentServiceModel, Comment.class);

        return this.commentRepository.save(comment) != null;
    }

    @Async
    @Override
    public CompletableFuture<Boolean> deleteComment(String loggedInUserId, String commentToRemoveId) throws Exception {
        User loggedInUser = this.userRepository.findById(loggedInUserId).orElse(null);
        Comment commentToRemove = this.commentRepository.findById(commentToRemoveId).orElse(null);

        if (!userValidation.isValid(loggedInUser) || !commentValidation.isValid(commentToRemove)) {
            throw new Exception(SERVER_ERROR_MESSAGE);
        }

        UserRole rootRole = this.roleRepository.findByAuthority("ROOT");
        boolean hasRootAuthority = loggedInUser.getAuthorities().contains(rootRole);
        boolean isCommentCreator = commentToRemove.getCreator().getId().equals(loggedInUserId);
        boolean isTimeLineUser = commentToRemove.getTimelineUser().getId().equals(loggedInUserId);

        if (hasRootAuthority || isCommentCreator || isTimeLineUser) {
            try {
                this.commentRepository.delete(commentToRemove);
                return CompletableFuture.completedFuture(true);
            } catch (Exception e) {
                throw new CustomException(SERVER_ERROR_MESSAGE);
            }
        } else {
            throw new Exception(SERVER_ERROR_MESSAGE);
        }
    }
}
