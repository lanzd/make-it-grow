package com.planning.application.order;

import com.planning.application.orderedvegetable.OrderedVegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class OrderEntityEventHandler {

    @Autowired
    OrderedVegetableService orderedVegetableService;

    @HandleAfterCreate
    public void handleOrderEntityCreate(OrderEntity orderEntity) {
        orderedVegetableService.createOrderedVegetablesFromOrder(orderEntity);
    }

    @HandleBeforeDelete
    public void handleOrderEntityDelete(OrderEntity orderEntity) {
        orderedVegetableService.deleteOrderedVegetablesFromOrder(orderEntity);
    }

    @HandleAfterSave
    public void handleOrderEntitySave(OrderEntity orderEntity) {
        orderedVegetableService.deleteOrderedVegetablesFromOrder(orderEntity);
        orderedVegetableService.createOrderedVegetablesFromOrder(orderEntity);
    }
}
