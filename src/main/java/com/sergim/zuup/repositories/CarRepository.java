package com.sergim.zuup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sergim.zuup.entities.Car;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT obj FROM Car obj JOIN FETCH obj.driver")
    List<Car> findAllCarsWithDriver();
}
