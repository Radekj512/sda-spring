package pl.sda.springmvc.springmvcDemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.sda.springmvc.springmvcDemo.dto.ProductDTO;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundProductException;
import pl.sda.springmvc.springmvcDemo.service.OrderService;
import pl.sda.springmvc.springmvcDemo.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {


    private final ProductService productService;
    private final OrderService orderService;


    private List<ProductDTO> productList = new ArrayList<>();

    @Autowired
    public ShoppingCart(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }


    public List<ProductDTO> getProducts(){
        return productList;
    }

    public void addProduct(Long productId) throws NotFoundProductException {
        ProductDTO productById = productService.getProductById(productId);
        productList.add(productById);
    }

    public void placeOrder(){
        List<Long> ids = new ArrayList<>();
        productList.forEach(x->ids.add(x.getId()));
        orderService.placeOrder(ids);
        productList.clear();
    }

}
