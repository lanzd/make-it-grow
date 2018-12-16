package com.planning.application.orderedvegetable;

import com.planning.application.order.OrderEntity;
import com.planning.application.vegetable.Vegetable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {
        @Index(name= "ordered_vegetable_idx_date", columnList = "date", unique = false),
        @Index(name= "ordered_vegetable_idx_order", columnList = "order_id", unique = false),
        @Index(name= "ordered_vegetable_idx_seeding_date", columnList = "maximumSeedingDate", unique = false),
})
public class OrderedVegetable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "vegetable_id")
    private Vegetable vegetable;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    private int quantity;

    private Date date;

    private Date maximumSeedingDate;

    public OrderedVegetable() {
    }

    public OrderedVegetable(long id, Vegetable vegetable, OrderEntity orderEntity, int quantity, Date date, Date maximumSeedingDate) {
        this.id = id;
        this.vegetable = vegetable;
        this.orderEntity = orderEntity;
        this.quantity = quantity;
        this.date = date;
        this.maximumSeedingDate = maximumSeedingDate;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getMaximumSeedingDate() {
        return maximumSeedingDate;
    }

    public void setMaximumSeedingDate(Date maximumSeedingDate) {
        this.maximumSeedingDate = maximumSeedingDate;
    }

    @Override
    public String toString() {
        return "OrderedVegetable{" +
                "id=" + id +
                ", vegetable='" + vegetable.toString() + '\'' +
                ", orderEntity='" + orderEntity.toString() + '\'' +
                ", date=" + date.toString() + '\'' +
                ", maximumSeedingDate=" + maximumSeedingDate.toString() + '\'' +
                '}';
    }
}
