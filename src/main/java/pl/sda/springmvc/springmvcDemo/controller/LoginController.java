package pl.sda.springmvc.springmvcDemo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.dto.NewProductDTO;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;

@Controller
public class LoginController {

    private final Validator loginValidator;

    @InitBinder
    private void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(loginValidator);
    }

    public LoginController(@Qualifier("loginValidator") Validator loginValidator) {
        this.loginValidator = loginValidator;
    }


    @RequestMapping("/login")
    public ModelAndView getForm(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new UserEntity());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") @Validated UserEntity user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("login");
        }else{
            return new ModelAndView("redirect:/products");
        }

    }

}
