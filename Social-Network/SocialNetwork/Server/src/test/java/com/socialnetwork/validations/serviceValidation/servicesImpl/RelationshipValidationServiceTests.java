package com.socialnetwork.validations.serviceValidation.servicesImpl;

import com.socialnetwork.domain.entities.Relationship;
import com.socialnetwork.domain.entities.User;
import com.socialnetwork.testUtils.RelationshipsUtils;
import com.socialnetwork.testUtils.UsersUtils;
import com.socialnetwork.validations.serviceValidation.services.RelationshipValidationService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RelationshipValidationServiceTests {
    private RelationshipValidationService relationshipValidationService;

    @Before
    public void setupTest(){
        relationshipValidationService = new RelationshipValidationServiceImpl();
    }

    @Test
    public void isValid_whenValid_true(){
        List<User> users = UsersUtils.getUsers(2);
        User userOne = users.get(0);
        User userTwo = users.get(1);

        Relationship relationship = RelationshipsUtils.createRelationship(userOne, userTwo, 0, userOne);

        boolean result = relationshipValidationService.isValid(relationship);
        assertTrue(result);
    }

    @Test
    public void isValid_whenNull_false(){
        Relationship relationship = null;
        boolean result = relationshipValidationService.isValid(relationship);
        assertFalse(result);
    }
}
