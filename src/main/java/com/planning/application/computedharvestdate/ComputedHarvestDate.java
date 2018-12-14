package com.planning.application.computedharvestdate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(indexes = {
        @Index(name= "harvest_date_idx_harvest_date", columnList = "harvestDate", unique = false)
})
public class ComputedHarvestDate {

    @EmbeddedId
    ComputedHarvestDateIdentity computedHarvestDateIdentity;

    @NotNull
    private Date harvestDate;

    public ComputedHarvestDate(ComputedHarvestDateIdentity computedHarvestDateIdentity, @NotNull Date harvestDate) {
        this.computedHarvestDateIdentity = computedHarvestDateIdentity;
        this.harvestDate = harvestDate;
    }

    public ComputedHarvestDateIdentity getComputedHarvestDateIdentity() {
        return computedHarvestDateIdentity;
    }

    public void setComputedHarvestDateIdentity(ComputedHarvestDateIdentity computedHarvestDateIdentity) {
        this.computedHarvestDateIdentity = computedHarvestDateIdentity;
    }

    public Date getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(Date harvestDate) {
        this.harvestDate = harvestDate;
    }
}
