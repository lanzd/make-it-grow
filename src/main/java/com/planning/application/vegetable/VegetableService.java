package com.planning.application.vegetable;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VegetableService {

    @Autowired
    VegetableRepository vegetableRepository;

    public Vegetable get(long connectorId) throws NotFoundException {
        Optional<Vegetable> optionalConnector = vegetableRepository.findById(connectorId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no vegetable " + connectorId);
    }
}
