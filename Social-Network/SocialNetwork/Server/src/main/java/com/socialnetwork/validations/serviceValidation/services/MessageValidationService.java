package com.socialnetwork.validations.serviceValidation.services;

import com.socialnetwork.domain.models.bindingModels.message.MessageCreateBindingModel;

public interface MessageValidationService {
    boolean isValid(MessageCreateBindingModel messageCreateBindingModel);
}
