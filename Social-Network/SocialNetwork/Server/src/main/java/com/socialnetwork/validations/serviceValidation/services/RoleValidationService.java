package com.socialnetwork.validations.serviceValidation.services;

import com.socialnetwork.domain.entities.UserRole;

public interface RoleValidationService {
    boolean isValid(UserRole role);
}
