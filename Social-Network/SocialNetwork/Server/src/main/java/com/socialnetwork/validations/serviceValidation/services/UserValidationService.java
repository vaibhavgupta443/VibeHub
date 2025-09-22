package com.socialnetwork.validations.serviceValidation.services;

import com.socialnetwork.domain.entities.User;
import com.socialnetwork.domain.models.bindingModels.user.UserRegisterBindingModel;
import com.socialnetwork.domain.models.bindingModels.user.UserUpdateBindingModel;
import com.socialnetwork.domain.models.serviceModels.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserValidationService {
    boolean isValid(User user);

    boolean isValid(UserServiceModel userServiceModel);

    boolean isValid(UserRegisterBindingModel userRegisterBindingModel);

    boolean isValid(String firstParam, String secondParam);

    boolean isValid(UserUpdateBindingModel userUpdateBindingModel);

    boolean isValid(UserDetails userData);
}
