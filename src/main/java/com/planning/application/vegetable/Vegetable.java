package com.planning.application.vegetable;

import com.planning.application.vegetable.vegetableParameters.VegetableParameters;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Vegetable implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    @Embedded
    private VegetableParameters vegetableParameters;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VegetableParameters getVegetableParameters() {
        return vegetableParameters;
    }

    public void setVegetableParameters(VegetableParameters vegetableParameters) {
        this.vegetableParameters = vegetableParameters;
    }

    @Override
    public String toString() {
        return "VegetableParameters{" +
                "id=" + id +
                "name=" + name +
                '}';
    }
}
