package com.sergim.zuup.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_history")
public class HistoryVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long carId;
    private String momentEnter;
    private String momentExit;

    public HistoryVacancy(){
    }

    public HistoryVacancy(Long id, Long carId, String momentEnter, String momentExit) {
        this.id = id;
        this.carId = carId;
        this.momentEnter = momentEnter;
        this.momentExit = momentExit;
    }

    public HistoryVacancy(Vacancy entity){
        this.id = entity.getId();
        this.carId = entity.getCarId();
        this.momentEnter = entity.getMomentEnter();
        this.momentExit = entity.getMomentExit();
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

