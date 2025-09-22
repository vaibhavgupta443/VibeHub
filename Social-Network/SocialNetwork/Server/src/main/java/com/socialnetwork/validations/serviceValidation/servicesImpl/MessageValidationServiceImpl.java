package com.socialnetwork.validations.serviceValidation.servicesImpl;

import com.socialnetwork.domain.models.bindingModels.message.MessageCreateBindingModel;
import com.socialnetwork.validations.serviceValidation.services.MessageValidationService;
import org.springframework.stereotype.Component;

@Component
public class MessageValidationServiceImpl implements MessageValidationService {

    @Override
    public boolean isValid(MessageCreateBindingModel messageCreateBindingModel) {
        return messageCreateBindingModel != null;
    }
}
