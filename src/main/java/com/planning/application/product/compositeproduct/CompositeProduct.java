package com.planning.application.product.compositeproduct;

import com.planning.application.product.Product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COMPOSITE")
public class CompositeProduct extends Product {

    @Override
    public String toString() {
        return "CompositeProductComponent{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
