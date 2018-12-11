package com.planning.application.vegetableCommand;

import com.planning.application.command.Command;
import com.planning.application.product.Product;
import com.planning.application.vegetable.Vegetable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {@Index(name= "vegetable_command_idx_date", columnList = "date", unique = false)})
public class VegetableCommand {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "vegetable_id")
    private Vegetable vegetable;

    @ManyToOne
    @JoinColumn(name = "command_id")
    private Command command;

    Date date;

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
        return "VegetableCommand{" +
                "id=" + id +
              //  ", compositeProduct='" + product.toString() + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
