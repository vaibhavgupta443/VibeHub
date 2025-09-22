package com.socialnetwork.validations.serviceValidation.servicesImpl;

import com.socialnetwork.domain.entities.Post;
import com.socialnetwork.domain.models.bindingModels.post.PostCreateBindingModel;
import com.socialnetwork.validations.serviceValidation.services.PostValidationService;
import org.springframework.stereotype.Component;

@Component
public class PostValidationServiceImpl implements PostValidationService {
    @Override
    public boolean isValid(Post post) {
        return post != null;
    }

    @Override
    public boolean isValid(PostCreateBindingModel postCreateBindingModel) {
        return postCreateBindingModel != null;
    }
}
