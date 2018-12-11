package com.planning.application.product.compositeproduct.component;

import java.io.Serializable;

public class CompositeProductComponent  implements Serializable {

    private long productId;

    private Integer quantity;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CompositeProductComponent{" +
                "productId=" + productId +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
