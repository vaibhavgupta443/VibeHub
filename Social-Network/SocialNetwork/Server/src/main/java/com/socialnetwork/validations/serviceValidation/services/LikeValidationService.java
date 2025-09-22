package com.socialnetwork.validations.serviceValidation.services;

import com.socialnetwork.domain.entities.Like;

public interface LikeValidationService {
    boolean isValid(Like like);
}
