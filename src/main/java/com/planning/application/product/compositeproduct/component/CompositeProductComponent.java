package com.planning.application.product.compositeproduct.component;

import com.planning.application.product.compositeproduct.CompositeProduct;
import com.planning.application.product.simpleproduct.SimpleProduct;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CompositeProductComponent  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private CompositeProduct product;

    @ManyToOne
    @JoinColumn(referencedColumnName ="id")
    private SimpleProduct component;

    private Integer quantity;


    public CompositeProductComponent() {
    }

    public CompositeProductComponent(long id, CompositeProduct product, SimpleProduct component, Integer quantity) {
        this.id = id;
        this.product = product;
        this.component = component;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CompositeProduct getProduct() {
        return product;
    }

    public void setProduct(CompositeProduct product) {
        this.product = product;
    }

    public SimpleProduct getComponent() {
        return component;
    }

    public void setComponent(SimpleProduct component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "CompositeProductComponent{" +
                "product=" + product.toString() +
                "component=" + component.toString() +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
