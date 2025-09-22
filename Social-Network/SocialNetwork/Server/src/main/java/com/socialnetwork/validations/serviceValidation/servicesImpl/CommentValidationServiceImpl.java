package com.socialnetwork.validations.serviceValidation.servicesImpl;

import com.socialnetwork.domain.entities.Comment;
import com.socialnetwork.domain.models.bindingModels.comment.CommentCreateBindingModel;
import com.socialnetwork.validations.serviceValidation.services.CommentValidationService;
import org.springframework.stereotype.Component;

@Component
public class CommentValidationServiceImpl implements CommentValidationService {
    @Override
    public boolean isValid(Comment comment) {
        return comment != null;
    }

    @Override
    public boolean isValid(CommentCreateBindingModel commentCreateBindingModel) {
        return commentCreateBindingModel != null;
    }
}
