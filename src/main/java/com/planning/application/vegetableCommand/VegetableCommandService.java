package com.planning.application.vegetableCommand;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VegetableCommandService {

    @Autowired
    VegetableCommandRepository vegetableVegetableCommandRepository;

    public VegetableCommand get(long connectorId) throws NotFoundException {
        Optional<VegetableCommand> optionalConnector = vegetableVegetableCommandRepository.findById(connectorId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no vegetable " + connectorId);
    }
}
