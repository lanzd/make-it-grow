package com.planning.application.vegetable.vegetableParameters;

import javax.persistence.Embeddable;

@Embeddable
public class VegetableParameters {

    private Integer growingTime;

    public Integer getGrowingTime() {
        return growingTime;
    }

    public void setGrowingTime(Integer growingTime) {
        this.growingTime = growingTime;
    }

    @Override
    public String toString() {
        return "VegetableParameters{" +
                ", growingTime='" + growingTime + '\'' +
                '}';
    }
}
