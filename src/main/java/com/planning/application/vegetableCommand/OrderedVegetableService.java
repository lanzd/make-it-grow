package com.planning.application.vegetableCommand;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderedVegetableService {

    @Autowired
    OrderedVegetableRepository vegetableOrderedVegetableRepository;

    public OrderedVegetable get(long connectorId) throws NotFoundException {
        Optional<OrderedVegetable> optionalConnector = vegetableOrderedVegetableRepository.findById(connectorId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no ordered vegetable " + connectorId);
    }
}
