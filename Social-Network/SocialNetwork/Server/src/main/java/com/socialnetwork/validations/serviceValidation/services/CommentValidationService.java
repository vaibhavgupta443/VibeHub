package com.socialnetwork.validations.serviceValidation.services;

import com.socialnetwork.domain.entities.Comment;
import com.socialnetwork.domain.models.bindingModels.comment.CommentCreateBindingModel;

public interface CommentValidationService {
    boolean isValid(Comment comment);

    boolean isValid(CommentCreateBindingModel commentCreateBindingModel);
}
