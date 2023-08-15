package com.example.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.app.entity.UserInfo;
import com.example.app.entity.UserInfoUserDetails;
import com.example.app.repository.UserInfoRepository;

@Component
@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = null;
        try {
            userInfo = userInfoRepository.findByName(username);
        } catch (Exception e) {
            System.out.println("exception");
        }
        return new UserInfoUserDetails(userInfo.get());
    }

}
