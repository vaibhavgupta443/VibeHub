package com.socialnetwork.validations.serviceValidation.services;

import com.socialnetwork.domain.entities.Relationship;

public interface RelationshipValidationService {
    boolean isValid(Relationship relationship);
}
