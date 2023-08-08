package org.nequiltaborn.imbibinglush.services;

import org.nequiltaborn.imbibinglush.exceptions.UsernameNotFoundException;
import org.nequiltaborn.imbibinglush.models.User;
import org.nequiltaborn.imbibinglush.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/*Business logic */


@Service
public class UserServiceImpl implements UserService{



    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }


    @Override
    public void save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getId(), registrationDto.getFName(), registrationDto.getLName(),
                registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()));

        userRepository.save(user);
    }


    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            try {
                throw new UsernameNotFoundException("Invalid username or password.");
            } catch (UsernameNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), null);
        }
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role>) {
//    }

    }


