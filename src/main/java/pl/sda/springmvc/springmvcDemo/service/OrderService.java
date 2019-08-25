package pl.sda.springmvc.springmvcDemo.service;

import pl.sda.springmvc.springmvcDemo.entity.OrderEntity;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundUserException;

import java.util.List;

public interface OrderService {

    void placeOrder(List<Long> productsIds, String username) throws NotFoundUserException;

    List<OrderEntity> findOrdersByUsername(String login);
}
