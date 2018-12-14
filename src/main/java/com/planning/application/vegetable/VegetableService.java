package com.planning.application.vegetable;

import com.planning.application.computedharvestdate.ComputedHarvestDate;
import com.planning.application.computedharvestdate.ComputedHarvestDateIdentity;
import com.planning.application.computedharvestdate.ComputedHarvestDateRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import static com.planning.application.vegetable.vegetableParameters.VegetableDefaultParameters.GROWING_TIME_SEASON_FACTOR;

@Service
public class VegetableService {

    private static int DEFAULT_HARVEST_PERIOD_TO_COMPUTE = 365;
    private static int DAY_IN_MILISECOND = 86400000; //1000 * 60 * 60 * 24


    @Autowired
    VegetableRepository vegetableRepository;

    @Autowired
    ComputedHarvestDateRepository computedHarvestDateRepository;

    public Vegetable get(long connectorId) throws NotFoundException {
        Optional<Vegetable> optionalConnector = vegetableRepository.findById(connectorId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no vegetable " + connectorId);
    }

    public Collection<ComputedHarvestDate> updateVegetableHarvestDates(Vegetable vegetable){
        deleteVegetableHarvestDates(vegetable);
        return computeVegetableHarvestDates(vegetable);
    }

    public Collection<ComputedHarvestDate> computeVegetableHarvestDates(Vegetable vegetable) {
        return this.computeVegetableHarvestDates(vegetable,DEFAULT_HARVEST_PERIOD_TO_COMPUTE);
    }

    private Collection<ComputedHarvestDate> computeVegetableHarvestDates(Vegetable vegetable, int duration) {
        ArrayList<ComputedHarvestDate> computedHarvestDates = new ArrayList<>();
        Date date = new Date();
        for(int i = 0;i<duration;i++){
            Date seedingDate = new Date(date.getTime() + DAY_IN_MILISECOND * i);
            Date harvestDate = new Date(seedingDate.getTime() + (vegetable.getVegetableParameters().getNurseryTime() + vegetable.getVegetableParameters().getGrowingTime())*DAY_IN_MILISECOND * GROWING_TIME_SEASON_FACTOR(seedingDate));
            computedHarvestDates.add(computedHarvestDateRepository.save(new ComputedHarvestDate(new ComputedHarvestDateIdentity(seedingDate,vegetable),harvestDate)));
        }
        return computedHarvestDates;
    }

    public void deleteVegetableHarvestDates(Vegetable vegetable){
        computedHarvestDateRepository.deleteAll(computedHarvestDateRepository.findByComputedHarvestDateIdentityVegetable(vegetable, PageRequest.of(0,100)));
    }
}
