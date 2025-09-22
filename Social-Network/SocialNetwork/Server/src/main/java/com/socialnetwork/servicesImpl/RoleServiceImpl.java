package com.socialnetwork.servicesImpl;

import com.socialnetwork.domain.entities.UserRole;
import com.socialnetwork.repositories.RoleRepository;
import com.socialnetwork.services.RoleService;
import com.socialnetwork.validations.serviceValidation.services.RoleValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.socialnetwork.utils.constants.ResponseMessageConstants.SERVER_ERROR_MESSAGE;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleValidationService roleValidation;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleValidationService roleValidation) {
        this.roleRepository = roleRepository;
        this.roleValidation = roleValidation;
    }

    @Override
    public boolean persist(UserRole role) throws Exception {
        if(!roleValidation.isValid(role)){
            throw new Exception(SERVER_ERROR_MESSAGE);
        }

        return this.roleRepository.save(role) != null;
    }

    @Override
    public UserRole getByName(String name) {
        return this.roleRepository.findByAuthority(name);
    }
}
