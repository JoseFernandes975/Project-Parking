package com.sergim.zuup.dto;
import com.sergim.zuup.entities.Car;
import com.sergim.zuup.entities.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverDTO {

    private Long id;
    private String name;
    private Integer age;
    private String qualification;


    public DriverDTO(Long id, String name, Integer age, String qualification) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.qualification = qualification;
    }


    public DriverDTO(Driver entity){
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
        qualification = entity.getQualification();

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getQualification() {
        return qualification;
    }
}
