package com.sergim.zuup.dto;

import com.sergim.zuup.entities.Car;

public class CarsDTO {
    private Long id;
    private String name;
    private String plate;
    private String color;

    public CarsDTO(Long id, String name, String plate, String color) {
        this.id = id;
        this.name = name;
        this.plate = plate;
        this.color = color;
    }

    public CarsDTO(Car entity){
        id = entity.getId();
        name = entity.getName();
        plate = entity.getPlate();
        color = entity.getColor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
