package com.planning.application.order;

import com.planning.application.product.Product;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {@Index(name= "order_idx_date", columnList = "date", unique = false)})
public class OrderEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Date date;

    private Integer quantity;

    public OrderEntity() {
    }

    public OrderEntity(long id, Product product, Date date, Integer quantity) {
        this.id = id;
        this.product = product;
        this.date = date;
        this.quantity = quantity;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderedVegetable{" +
                "id=" + id +
              //  ", compositeProduct='" + product.toString() + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
