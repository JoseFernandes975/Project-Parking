package com.sergim.zuup.dto;

import com.sergim.zuup.entities.Car;
import com.sergim.zuup.entities.Driver;

public class CarDTO {

    private Long id;
    private String name;
    private String plate;
    private String color;
    private Long driverId;

    public CarDTO(Long id, String name, String plate, String color, Long driverId) {
        this.id = id;
        this.name = name;
        this.plate = plate;
        this.driverId = driverId;
        this.color = color;
    }

    public CarDTO(Car entity){
        id = entity.getId();
        name = entity.getName();
        plate = entity.getPlate();
        color = entity.getColor();
     /*   for(Driver dr : entity.getDriver()){
            driverId.add(new DriverDTO(dr));
       */driverId = entity.getDriver().getId();
                //new DriverCarDTO(entity.getDriver());
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

    public Long getDriverId() {
        return driverId;
    }
}
