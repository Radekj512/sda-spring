package pl.sda.springmvc.springmvcDemo.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.repository.UserRepository;
import pl.sda.springmvc.springmvcDemo.service.UserService;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity findUser(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    @Transactional
    public void addUser(UserEntity userEntity) {
        UserEntity u = userEntity;
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        userRepository.save(u);
    }
}
