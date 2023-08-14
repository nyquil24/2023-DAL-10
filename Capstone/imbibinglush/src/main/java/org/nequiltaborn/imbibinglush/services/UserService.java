package org.nequiltaborn.imbibinglush.services;


import org.nequiltaborn.imbibinglush.models.User;
import org.nequiltaborn.imbibinglush.services.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);


}
