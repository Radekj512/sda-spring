package pl.sda.springmvc.springmvcDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.sda.springmvc.springmvcDemo.dto.NewProductDTO;
import pl.sda.springmvc.springmvcDemo.dto.ProductDTO;
import pl.sda.springmvc.springmvcDemo.entity.ProductEntity;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundProductException;
import pl.sda.springmvc.springmvcDemo.exception.WebApplicationException;
import pl.sda.springmvc.springmvcDemo.mapper.ModelMapper;
import pl.sda.springmvc.springmvcDemo.repository.ProductRepository;
import pl.sda.springmvc.springmvcDemo.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void addProduct(NewProductDTO newProductDTO) {
        ProductEntity productEntity = ProductEntity
                .builder()
                .name(newProductDTO.getName())
                .price(newProductDTO.getPrice())
                .build();
        productRepository.save(productEntity);
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(ModelMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(long idProduct) {

    }

    @Override
    public ProductDTO getProductById(long idProduct) throws NotFoundProductException {
        Optional<ProductEntity> productById = productRepository.findById(idProduct);
        return productById
                .map(ModelMapper::map)
                .orElseThrow(() ->
                        new NotFoundProductException("Not found product with ID: " + idProduct));
    }
}