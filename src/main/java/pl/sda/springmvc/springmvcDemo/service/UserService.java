package pl.sda.springmvc.springmvcDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.repository.UserRepository;

public interface UserService {
  UserEntity findUser(String username);

}
