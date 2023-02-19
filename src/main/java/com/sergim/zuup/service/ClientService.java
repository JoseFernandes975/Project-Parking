package com.sergim.zuup.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sergim.zuup.dto.CarsDTO;
import com.sergim.zuup.dto.DriverDTO;
import com.sergim.zuup.entities.Car;
import com.sergim.zuup.exception.DataBaseException;
import com.sergim.zuup.exception.ResourceNotFoundException;
import com.sergim.zuup.repositories.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sergim.zuup.entities.Driver;
import com.sergim.zuup.repositories.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private CarRepository repo;

	@Transactional(readOnly = true)
	public DriverDTO findById(Long id) {
		Optional<Driver> obj = repository.findById(id);
		Driver entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id not found!"));
		return new DriverDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<CarsDTO> findDriverCarsById(Long id){
		Optional<Driver> result = repository.findById(id);
		List<Car> list = result.get().getCars();
		return list.stream().map(x -> new CarsDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public List<DriverDTO> findAll() {
		List<Driver> list = repository.findAll();
		return list.stream().map(x -> new DriverDTO(x)).collect(Collectors.toList());
	}
	@Transactional
	public DriverDTO insert(DriverDTO obj) {
		if (obj.getAge() < 18 || obj.getQualification() == "false") {
			throw new ResourceNotFoundException("Dados incorretos!");
		}
		Driver driver = new Driver();
		driver.setId(obj.getId());
		driver.setName(obj.getName());
		driver.setAge(obj.getAge());
		driver.setQualification(obj.getQualification());
		repository.save(driver);
		 return new DriverDTO(driver);
	}

	@Transactional
	public void delete(Long id){
       try {
		   repository.deleteById(id);
	   }catch(EmptyResultDataAccessException e) {
		throw new ResourceNotFoundException("iD not found!");
	}catch(DataIntegrityViolationException e) {
		throw new DataBaseException("Integrity violation, object associate!");
	}
	}

	@Transactional
	public DriverDTO update(Long id, DriverDTO obj){
		try {
			Driver entity = repository.getOne(id);
			entity.setName(obj.getName());
			entity.setAge(obj.getAge());
			entity.setQualification(obj.getQualification());
			entity = repository.save(entity);
			return new DriverDTO(entity);
		}catch (EntityNotFoundException e){
			throw new ResourceNotFoundException("Id not found!");
		}
	}

	private void updateData(DriverDTO obj, Driver entity){
		entity.setId(obj.getId());
		entity.setName(obj.getName());
		entity.setAge(obj.getAge());
		entity.setQualification(obj.getQualification());
	}
	
}
