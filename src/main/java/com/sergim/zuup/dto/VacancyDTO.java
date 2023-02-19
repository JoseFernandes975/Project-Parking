package com.sergim.zuup.dto;

import com.sergim.zuup.entities.Vacancy;

public class VacancyDTO {

    private Long id;
    private Long carId;
    private String momentEnter;
    private String momentExit;

    public VacancyDTO(){
    }

    public VacancyDTO (Vacancy entities){
        this.id = entities.getId();
        this.carId = entities.getCarId();
        this.momentEnter = entities.getMomentEnter();
        this.momentExit = entities.getMomentExit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
