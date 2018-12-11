package com.planning.application.product;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product get(long productId) throws NotFoundException {
        Optional<Product> optionalConnector = productRepository.findById(productId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no product " + productId);
    }
}
