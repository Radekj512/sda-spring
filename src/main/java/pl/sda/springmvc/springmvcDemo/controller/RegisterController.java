package pl.sda.springmvc.springmvcDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.exception.UserAlreadyExistException;
import pl.sda.springmvc.springmvcDemo.service.UserService;

@Controller
public class RegisterController {

    private final UserService userService;
    private final Validator loginValidator;

    public RegisterController(UserService userService, Validator loginValidator) {
        this.userService = userService;
        this.loginValidator = loginValidator;
    }

    @InitBinder
    private void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(loginValidator);
    }

    @RequestMapping("/register")
    public ModelAndView registerForm() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("newUser", new UserEntity());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("newUser") UserEntity user, BindingResult bindingResult) throws UserAlreadyExistException {

       if( userService.findUser(user.getUsername()) != null){
           throw new UserAlreadyExistException("User with login: " + user.getUsername() + " already exist");
       }


        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        } else {
            userService.addUser(user);
            return new ModelAndView("redirect:/");
        }

    }
}
