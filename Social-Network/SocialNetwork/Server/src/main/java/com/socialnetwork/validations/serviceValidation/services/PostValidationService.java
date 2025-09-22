package com.socialnetwork.validations.serviceValidation.services;

import com.socialnetwork.domain.entities.Post;
import com.socialnetwork.domain.models.bindingModels.post.PostCreateBindingModel;

public interface PostValidationService {
    boolean isValid(Post post);

    boolean isValid(PostCreateBindingModel postCreateBindingModel);
}
