package org.nequiltaborn.imbibinglush.services;

import jakarta.transaction.Transactional;
import org.nequiltaborn.imbibinglush.models.Role;
import org.nequiltaborn.imbibinglush.models.User;
import org.nequiltaborn.imbibinglush.repositories.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.nequiltaborn.imbibinglush.services.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    	@Autowired
    	private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFName(), registrationDto.getLName(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getRoles());
        return userRepository.save(user);
    }




    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws RuntimeException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new RuntimeException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));


    }



    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
