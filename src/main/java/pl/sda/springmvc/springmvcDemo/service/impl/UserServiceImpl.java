package pl.sda.springmvc.springmvcDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.repository.UserRepository;
import pl.sda.springmvc.springmvcDemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findUser(String username) {
        return userRepository.findByUsername(username);
    }
}
