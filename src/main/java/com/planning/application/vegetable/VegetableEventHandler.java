package com.planning.application.vegetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class VegetableEventHandler {

    @Autowired
    VegetableService vegetableService;

    @HandleAfterCreate
    public void handleVegetableCreate(Vegetable vegetable) {
        vegetableService.computeVegetableHarvestDates(vegetable);
    }

    @HandleBeforeDelete
    public void handleVegetableDelete(Vegetable vegetable) {
        vegetableService.deleteVegetableHarvestDates(vegetable);
    }

    @HandleAfterSave
    public void handleVegetableSave(Vegetable vegetable) {
        vegetableService.updateVegetableHarvestDates(vegetable);
    }
}
