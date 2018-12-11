package com.planning.application.product.compositeproduct;

import com.planning.application.product.compositeproduct.component.CompositeProductComponent;
import com.planning.application.product.Product;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("COMPOSITE")
public class CompositeProduct extends Product {

    private ArrayList<CompositeProductComponent> composition;

    public ArrayList<CompositeProductComponent> getComposition() {
        return composition;
    }

    public void setComposition(ArrayList<CompositeProductComponent> composition) {
        this.composition = composition;
    }

    @Override
    public String toString() {
        return "CompositeProductComponent{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", composition='" + composition.toString() + '\'' +
                '}';
    }
}
