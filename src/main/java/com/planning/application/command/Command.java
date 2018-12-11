package com.planning.application.command;

import com.planning.application.product.Product;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Command {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Product product;

    private Date date;

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

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
              //  ", compositeProduct='" + product.toString() + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
