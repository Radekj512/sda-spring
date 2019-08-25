package pl.sda.springmvc.springmvcDemo.entity;

import lombok.*;
import pl.sda.springmvc.springmvcDemo.dto.ProductDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "order_")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creationTime = LocalDateTime.now();
    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<ProductEntity> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;


 }
