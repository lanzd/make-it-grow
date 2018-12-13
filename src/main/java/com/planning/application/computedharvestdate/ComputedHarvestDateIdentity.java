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

}
