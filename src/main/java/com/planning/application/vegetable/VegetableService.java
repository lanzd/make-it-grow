package com.planning.application.vegetable;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class VegetableService {

    private static int DEFAULT_HARVEST_PERIOD_TO_COMPUTE = 365;
    private static int DAY_IN_MILISECOND = 86400000; //1000 * 60 * 60 * 24


    @Autowired
    VegetableRepository vegetableRepository;


    public Vegetable get(long connectorId) throws NotFoundException {
        Optional<Vegetable> optionalConnector = vegetableRepository.findById(connectorId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no vegetable " + connectorId);
    }

    public Date findMaximumSeedingDateForHarvestDate(Vegetable vegetable,Date harvestDate){
        Integer totalTime = vegetable.getVegetableParameters().getTimeBeforeHarvest();
        Calendar harvestDateCal = getCalendarDate(harvestDate,12);
        Calendar refSeedingDate = getCalendarDate(new Date(harvestDate.getTime() - totalTime * DAY_IN_MILISECOND),12);
        return searchMaximumSeedingDateForHarvestDateFromRefDate(totalTime,harvestDateCal,refSeedingDate).getTime();
    }

    private Calendar searchMaximumSeedingDateForHarvestDateFromRefDate(Integer timeToGrow, Calendar harvestDate, Calendar refDate){
        Calendar refHarvestDate = Calendar.getInstance();
        refHarvestDate.setTime(new Date(Math.round(refDate.getTime().getTime() + getDateGrowingFactor(refDate) * timeToGrow)));
        if(refHarvestDate.equals(harvestDate)) {
            return refDate;
        } else {
            Calendar newRefDate = Calendar.getInstance();
            newRefDate.setTime(new Date(refDate.getTimeInMillis() - (harvestDate.getTimeInMillis() - refHarvestDate.getTimeInMillis())));
            if(sameDay(newRefDate,refDate)){
                return refDate;
            }
            return searchMaximumSeedingDateForHarvestDateFromRefDate(timeToGrow,harvestDate,refDate);
        }
    }

    private boolean sameDay(Calendar cal1, Calendar cal2) {
        return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }

    private Calendar getCalendarDate(Date date, Integer hours){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if(hours != null) {
            calendar.set(Calendar.HOUR_OF_DAY, hours);
        }
        return calendar;
    }

    private Double getDateGrowingFactor(Calendar date) {
        return null;
    }
}
