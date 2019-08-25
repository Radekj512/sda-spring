package pl.sda.springmvc.springmvcDemo.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvcDemo.entity.OrderEntity;
import pl.sda.springmvc.springmvcDemo.entity.ProductEntity;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundUserException;
import pl.sda.springmvc.springmvcDemo.repository.OrderRepository;
import pl.sda.springmvc.springmvcDemo.repository.ProductRepository;
import pl.sda.springmvc.springmvcDemo.repository.UserRepository;
import pl.sda.springmvc.springmvcDemo.service.OrderService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public void placeOrder(List<Long> productsIds, String username) throws NotFoundUserException {
        OrderEntity order = new OrderEntity();
        List<ProductEntity> products = productsIds.stream()
                .map(productRepository::getOne)
                .collect(Collectors.toList());
//        order.setProducts(products);
        for (ProductEntity x : products) {
            order.getProducts().add(x);
            x.getOrders().add(order);
        }
        Optional<UserEntity> byUsername = userRepository.findByUsername(username);

        UserEntity user = byUsername.orElseThrow(() -> new NotFoundUserException("User not found"));
        user.getOrders().add(order);
        order.setUser(user);
        orderRepository.save(order);
    }
    @Override
    public List<OrderEntity> findOrdersByUsername(String login){
        return orderRepository.findOrderEntitiesByUser_Username(login);
    }
}
