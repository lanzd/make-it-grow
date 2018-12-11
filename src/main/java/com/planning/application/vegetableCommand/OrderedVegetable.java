package com.planning.application.vegetableCommand;

import com.planning.application.order.OrderEntity;
import com.planning.application.vegetable.Vegetable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {@Index(name= "ordered_vegetable_idx_date", columnList = "date", unique = false)})
public class OrderedVegetable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "vegetable_id")
    private Vegetable vegetable;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    private Date date;

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderedVegetable{" +
                "id=" + id +
                ", vegetable='" + vegetable.toString() + '\'' +
                ", orderEntity='" + orderEntity.toString() + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
