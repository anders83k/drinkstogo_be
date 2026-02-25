package edu.jensen.drinkstogo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dish;
    private String components;
    public Sides(){

    }
    public Sides(int id, String dish, String components){
        this.id = id;
        this.dish = dish;
        this.components = components;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDish() {
        return dish;

    }

    public void setDish(String dish) {
        this.dish = dish;
    }
    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }
}
