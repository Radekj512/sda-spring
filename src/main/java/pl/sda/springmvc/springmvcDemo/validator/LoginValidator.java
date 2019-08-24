package pl.sda.springmvc.springmvcDemo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.service.UserService;

@Component
public class LoginValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserEntity user = (UserEntity) o;
        UserEntity user1 = userService.findUser(user.getUsername());
        if (user1 == null || (!user.getPassword().equals(user1.getPassword()) || !user.getUsername().equals(user1.getUsername()))) {
            errors.rejectValue("username", "user.validator.credentials.wrong");
        }
    }
}
