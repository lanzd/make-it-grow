package com.planning.application.vegetable.vegetableParameters;

import com.planning.application.product.simpleproduct.Unit;
import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Embeddable
public class VegetableParameters {

    // Needed Time (in days) for the vegetable to grow on field (after the seedling nursery)
    private int growingTime;

    // Needed Time (in days) for the vegetable to grow in seedling nursery
    private int nurseryTime;

    // The Harvest Window (in days)
    private int harvestWindow;

    // Loss % during the seedling nursery time
    private Integer nuseryLossFactor;

    // Loss % during the field time
    private Integer fieldLossFactor;

    private Unit seedlingUnit;

    private HashMap<Unit,Double> unitConversionFactor = new HashMap<>();

    public int getGrowingTime() {
        return growingTime;
    }

    public void setGrowingTime(int growingTime) {
        this.growingTime = growingTime;
    }

    public int getNurseryTime() {
        return nurseryTime;
    }

    public void setNurseryTime(int nurseryTime) {
        this.nurseryTime = nurseryTime;
    }

    public int getHarvestWindow() {
        return harvestWindow;
    }

    public void setHarvestWindow(int harvestWindow) {
        this.harvestWindow = harvestWindow;
    }

    public Integer getNuseryLossFactor() {
        return nuseryLossFactor;
    }

    public void setNuseryLossFactor(Integer nuseryLossFactor) {
        this.nuseryLossFactor = nuseryLossFactor;
    }

    public Integer getFieldLossFactor() {
        return fieldLossFactor;
    }

    public void setFieldLossFactor(Integer fieldLossFactor) {
        this.fieldLossFactor = fieldLossFactor;
    }

    public Unit getSeedlingUnit() {
        return seedlingUnit;
    }

    public void setSeedlingUnit(Unit seedlingUnit) {
        this.seedlingUnit = seedlingUnit;
    }

    public HashMap<Unit,Double> getUnitConversionFactor() {
        return unitConversionFactor;
    }

    public void setUnitConversionFactor(HashMap<Unit,Double> unitConversionFactor) {
        this.unitConversionFactor = unitConversionFactor;
    }

    @Override
    public String toString() {
        return "VegetableParameters{" +
                ", growingTime='" + growingTime + '\'' +
                ", nurseryTime='" + nurseryTime + '\'' +
                ", harvestWindow='" + harvestWindow + '\'' +
                ", nuseryLossFactor='" + nuseryLossFactor + '\'' +
                ", fieldLossFactor='" + fieldLossFactor + '\'' +
                ", seedlingUnit=" + seedlingUnit + '\'' +
                '}';
    }
}
