package com.planning.application.product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorColumn(name = "product_type")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
