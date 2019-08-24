package pl.sda.springmvc.springmvcDemo.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvcDemo.entity.OrderEntity;
import pl.sda.springmvc.springmvcDemo.entity.ProductEntity;
import pl.sda.springmvc.springmvcDemo.repository.OrderRepository;
import pl.sda.springmvc.springmvcDemo.repository.ProductRepository;
import pl.sda.springmvc.springmvcDemo.service.OrderService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    @Override
    @Transactional
    public void placeOrder(List<Long> productsIds) {
        OrderEntity order = new OrderEntity();
        List<ProductEntity> products = productsIds.stream()
                .map(productRepository::getOne)
                .collect(Collectors.toList());
//        order.setProducts(products);
        for (ProductEntity x : products) {
            order.getProducts().add(x);
            x.getOrders().add(order);
        }
        orderRepository.save(order);
    }
}
