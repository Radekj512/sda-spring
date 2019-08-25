package pl.sda.springmvc.springmvcDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.springmvc.springmvcDemo.entity.OrderEntity;

import javax.persistence.criteria.Order;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findOrderEntitiesByUser_Username(String username);
}
