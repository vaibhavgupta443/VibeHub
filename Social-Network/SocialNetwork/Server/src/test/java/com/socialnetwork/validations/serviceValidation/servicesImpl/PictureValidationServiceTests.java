package com.socialnetwork.validations.serviceValidation.servicesImpl;

import com.socialnetwork.domain.entities.Picture;
import com.socialnetwork.domain.entities.User;
import com.socialnetwork.testUtils.PictureUtils;
import com.socialnetwork.testUtils.UsersUtils;
import com.socialnetwork.validations.serviceValidation.services.PictureValidationService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PictureValidationServiceTests {
    private PictureValidationService pictureValidationService;

    @Before
    public void setupTest() {
        pictureValidationService = new PictureValidationServiceImpl();
    }

    @Test
    public void isValid_whenValid_true() {
        User user = UsersUtils.createUser();
        Picture picture = PictureUtils.createPicture(user);

        boolean result = pictureValidationService.isValid(picture);
        assertTrue(result);
    }

    @Test
    public void isValid_whenNull_false() {
        Picture picture = null;
        boolean result = pictureValidationService.isValid(picture);
        assertFalse(result);
    }
}
