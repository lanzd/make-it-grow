package com.planning.application.computedharvestdate;

import com.planning.application.vegetable.Vegetable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ComputedHarvestDateIdentity implements Serializable {

    @NotNull
    private Date seedingDay;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "vegetable_id")
    private Vegetable vegetable;


    public ComputedHarvestDateIdentity(@NotNull Date seedingDay, @NotNull Vegetable vegetable) {
        this.seedingDay = seedingDay;
        this.vegetable = vegetable;
    }

    public Date getSeedingDay() {
        return seedingDay;
    }

    public void setSeedingDay(Date seedingDay) {
        this.seedingDay = seedingDay;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }
}
