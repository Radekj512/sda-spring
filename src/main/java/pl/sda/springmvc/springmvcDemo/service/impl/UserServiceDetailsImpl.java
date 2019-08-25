package pl.sda.springmvc.springmvcDemo.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.repository.UserRepository;

import java.util.*;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserServiceDetailsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<UserEntity> byLogin = userRepository.findByUsername(s);
        UserEntity user = byLogin.orElseThrow(() -> new UsernameNotFoundException("Not found user with login: " + s));
        return new User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserEntity user) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (user.getUsername().equalsIgnoreCase("admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return authorities;
    }


}
