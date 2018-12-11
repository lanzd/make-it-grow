package com.planning.application.command;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommandService {

    @Autowired
    CommandRepository vegetableCommandRepository;

    public Command get(long connectorId) throws NotFoundException {
        Optional<Command> optionalConnector = vegetableCommandRepository.findById(connectorId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no vegetable " + connectorId);
    }
}
