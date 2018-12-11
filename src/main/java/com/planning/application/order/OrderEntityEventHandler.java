package com.planning.application.order;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class OrderEntityEventHandler {


    @HandleAfterCreate
    public void handleOrderEntityCreate(OrderEntity orderEntity) {
        //TODO create linked OrderedVegetable
        System.out.println("handle oder create : " + orderEntity.toString());
    }

    @HandleBeforeDelete
    public void handleOrderEntityDelete(OrderEntity orderEntity) {
        //TODO delete linked OrderedVegetable
        System.out.println("handle oder delete : " + orderEntity.toString());
    }

    @HandleAfterCreate
    public void handleOrderEntitySave(OrderEntity orderEntity) {
        //TODO update linked OrderedVegetable (delete and create ?)
        System.out.println("handle oder save : " + orderEntity.toString());
    }
}
