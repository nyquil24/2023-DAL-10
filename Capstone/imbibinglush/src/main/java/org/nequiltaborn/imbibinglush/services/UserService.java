package org.nequiltaborn.imbibinglush.services;


import org.nequiltaborn.imbibinglush.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void save(UserRegistrationDto registrationDto);

    User findUserByEmail(String email);
}
