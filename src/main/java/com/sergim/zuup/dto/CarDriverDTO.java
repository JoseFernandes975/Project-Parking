package com.sergim.zuup.dto;
import com.sergim.zuup.entities.Car;
public class CarDriverDTO {
    private Long id;
    private String name;
    private String plate;
    private String color;
    private DriverDTO driver;

    public CarDriverDTO(Long id, String name, String plate, String color, DriverDTO driver) {
        this.id = id;
        this.name = name;
        this.plate = plate;
        this.color = color;
        this.driver = driver;
    }

    public CarDriverDTO(Car entity){
        id = entity.getId();
        name = entity.getName();
        plate = entity.getPlate();
        color = entity.getColor();
        driver = new DriverDTO(entity.getDriver());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlate() {
        return plate;
    }

    public String getColor() {
        return color;
    }

    public DriverDTO getDriver() {
        return driver;
    }
}
