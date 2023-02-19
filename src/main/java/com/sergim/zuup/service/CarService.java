package com.sergim.zuup.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sergim.zuup.dto.CarDTO;
import com.sergim.zuup.dto.CarDriverDTO;
import com.sergim.zuup.dto.DriverDTO;
import com.sergim.zuup.exception.ResourceNotFoundException;
import com.sergim.zuup.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergim.zuup.entities.Car;
import com.sergim.zuup.entities.Driver;
import com.sergim.zuup.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	@Autowired
	private ClientRepository repo;

	@Transactional(readOnly = true)
	public List<CarDriverDTO> findAllCarWithDriver(){
		List<Car> list = repository.findAllCarsWithDriver();
		return list.stream().map(x -> new CarDriverDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CarDTO findById(Long id) {
		Optional<Car> car = repository.findById(id);
		car.orElseThrow(() -> new ResourceNotFoundException("Id not found!"));
		return new CarDTO(car.get());
	}

	@Transactional(readOnly = true)
	public CarDriverDTO findByIdCarWithDriver(Long id){
		Optional<Car> result = repository.findById(id);
		result.orElseThrow(() -> new ResourceNotFoundException("Id not found!"));
		return new CarDriverDTO(result.get());
	}

	@Transactional
	public CarDTO insert(CarDTO obj) {
		Car car = new Car();
		car.setId(obj.getId());
		car.setName(obj.getName());
		car.setPlate(obj.getPlate());
		car.setColor(obj.getColor());
		Driver driver = repo.getReferenceById(obj.getDriverId());
	//	Driver driver = new Driver();
	//	driver.setId(obj.getDriver().getId());
		car.setDriver(driver);
		car = repository.save(car);
        return new CarDTO(car);
	}


	public void deleteById(Long id){
		try{
		repository.deleteById(id);
	}catch(EmptyResultDataAccessException e) {
		throw new ResourceNotFoundException("Id not found!");
	}
	}

	@Transactional
	public CarDriverDTO update(Long id, CarDriverDTO obj){
		try{
		Car entity = repository.getReferenceById(id);
		Driver driver = repo.getReferenceById(obj.getDriver().getId());
		entity.setDriver(driver);
		entity.setName(obj.getName());
		entity.setColor(obj.getColor());
		entity.setPlate(obj.getPlate());
		entity = repository.save(entity);
		return new CarDriverDTO(entity);
	}catch(EntityNotFoundException e) {
		throw new ResourceNotFoundException("Id não encontrado!");
	}
	}


}
