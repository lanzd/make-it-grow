package com.planning.application.product.simpleproduct;

import com.planning.application.product.Product;
import com.planning.application.vegetable.Vegetable;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SIMPLE")
public class SimpleProduct extends Product {

    @ManyToOne
    @JoinColumn(name = "vegetable_id")
    Vegetable vegetable;

    Integer quantity;

    Unit unit;

    public SimpleProduct() {
    }

    public SimpleProduct(long id, String name, Vegetable vegetable, Integer quantity, Unit unit) {
        super(id, name);
        this.vegetable = vegetable;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "SimpleProductComponent{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", vegetable='" + vegetable.toString() + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
