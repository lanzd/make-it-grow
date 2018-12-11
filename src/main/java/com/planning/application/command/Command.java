package com.planning.application.command;

import com.planning.application.product.Product;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {@Index(name= "command_idx_date", columnList = "date", unique = false)})
public class Command {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Product product;

    private Date date;

    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "VegetableCommand{" +
                "id=" + id +
              //  ", compositeProduct='" + product.toString() + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
