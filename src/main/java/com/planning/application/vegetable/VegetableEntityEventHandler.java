package com.planning.application.vegetable;

import com.planning.application.order.OrderEntity;
import com.planning.application.vegetableCommand.OrderedVegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class VegetableEntityEventHandler {

    @Autowired
    OrderedVegetableService orderedVegetableService;

    @HandleAfterCreate
    public void handleOrderEntityCreate(OrderEntity orderEntity) {
        //create daily planning
    }

    @HandleBeforeDelete
    public void handleOrderEntityDelete(OrderEntity orderEntity) {
        //delete daily planning
    }

    @HandleAfterSave
    public void handleOrderEntitySave(OrderEntity orderEntity) {
        //delete daily planning
        //create daily planning
    }
}
