package com.planning.application.product.simpleproduct;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimpleProductService {

    @Autowired
    SimpleProductRepository simpleProductRepository;

    public SimpleProduct get(long connectorId) throws NotFoundException {
        Optional<SimpleProduct> optionalConnector = simpleProductRepository.findById(connectorId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no vegetable " + connectorId);
    }
}
