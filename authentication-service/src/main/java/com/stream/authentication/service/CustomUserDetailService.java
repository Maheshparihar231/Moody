package com.stream.authentication.service;

import com.stream.authentication.model.User;
import com.stream.authentication.repository.UserRepository;
import org.aspectj.weaver.tools.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired(required = true)
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        //load user from database
        User user = userRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("User Not Found"));

        return user;
    }


}
