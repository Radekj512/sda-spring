package pl.sda.springmvc.springmvcDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.entity.OrderEntity;
import pl.sda.springmvc.springmvcDemo.service.OrderService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {

    private final OrderService orderService;

    public ProfileController(OrderService orderService) {
        this.orderService = orderService;
    }


    @RequestMapping("/profile")
    public ModelAndView getProfile(Principal principal){
        ModelAndView mav = new ModelAndView("profile");
        List<OrderEntity> ordersByUsername = orderService.findOrdersByUsername(principal.getName());
        mav.addObject("orders", ordersByUsername);
        return mav;
    }
}
