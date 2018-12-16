package com.planning.application.vegetable;

import com.planning.application.orderedvegetable.OrderedVegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class VegetableEventHandler {

    @Autowired
    OrderedVegetableService orderedVegetableService;

//    @HandleAfterCreate
//    public void handleVegetableCreate(Vegetable vegetable) {
//    }
//
//    @HandleBeforeDelete
//    public void handleVegetableDelete(Vegetable vegetable) {
//    }

    @HandleAfterSave
    public void handleVegetableSave(Vegetable vegetable) {
        orderedVegetableService.updateOrderedVegetableMaximumSeedingDate(vegetable);
    }
}
