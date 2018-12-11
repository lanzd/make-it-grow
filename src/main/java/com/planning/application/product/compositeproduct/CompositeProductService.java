package com.planning.application.product.compositeproduct;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompositeProductService {

    @Autowired
    CompositeProductRepository compositeProductRepository;

    public CompositeProduct get(long connectorId) throws NotFoundException {
        Optional<CompositeProduct> optionalConnector = compositeProductRepository.findById(connectorId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no vegetable " + connectorId);
    }
}
