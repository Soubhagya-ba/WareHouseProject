package com.example.warehouse.security;
import com.example.warehouse.entity.User;
import com.example.warehouse.enums.UserRole;
import com.example.warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User Name Not Found!"));
       return org.springframework.security.core.userdetails.User.builder()
               .username(user.getEmail())
               .password(user.getPassword())
               .authorities(user.getUserRole().name())
               .build();
    }
}

