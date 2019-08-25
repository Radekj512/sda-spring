package pl.sda.springmvc.springmvcDemo.controller;

import groovyjarjarpicocli.CommandLine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.component.ShoppingCart;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundProductException;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundUserException;

import java.security.Principal;

@Controller
public class ShopCartController {

    private final ShoppingCart shoppingCart;

    public ShopCartController(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @RequestMapping("/cart")
    public ModelAndView getCart(){
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("products", shoppingCart.getProducts());
        return mav;
    }

    @PostMapping("cart/add/{id}")
    public ModelAndView addToCart(@PathVariable(value="id") String id) throws NotFoundProductException {
        shoppingCart.addProduct(Long.parseLong(id));
        return new ModelAndView("redirect:/cart");
    }

    @PostMapping("/cart/placeorder")
    public ModelAndView placeOrder(Principal principal) throws NotFoundProductException, NotFoundUserException {
        shoppingCart.placeOrder(principal.getName());
        return new ModelAndView("redirect:/cart");
    }
}
