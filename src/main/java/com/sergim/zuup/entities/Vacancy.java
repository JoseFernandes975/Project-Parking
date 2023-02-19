package com.sergim.zuup.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sergim.zuup.dto.CarDTO;
import com.sergim.zuup.dto.CarDriverDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Vacancy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long carId;
    private String momentEnter;
    private String momentExit;


    public Vacancy(){
    }

    public Vacancy(Long id, Long carId, String momentEnter, String momentExit) {
        this.id = id;
        this.carId = carId;
        this.momentEnter = momentEnter;
        this.momentExit = momentExit;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getMomentEnter() {
        return momentEnter;
    }

    public void setMomentEnter(String momentEnter) {
        this.momentEnter = momentEnter;
    }

    public String getMomentExit() {
        return momentExit;
    }

    public void setMomentExit(String momentExit) {
        this.momentExit = momentExit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
