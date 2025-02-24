package com.shop.cafe.config;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.cafe.model.Users;
import com.shop.cafe.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerUsersDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    private Users userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername {}", username);

        userDetails = userRepository.findByEmailId(username);
        if (!Objects.isNull(userDetails))
            return new User(userDetails.getEmail(),
                    userDetails.getPasswd(),
                    new ArrayList<>());
        else
            throw new UsernameNotFoundException(username + " not found");
    }

    public Users getUserDetails() {
        return userDetails;
    }
}
