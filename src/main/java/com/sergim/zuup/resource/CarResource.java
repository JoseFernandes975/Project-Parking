package com.sergim.zuup.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.sergim.zuup.dto.CarDTO;
import com.sergim.zuup.dto.CarDriverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sergim.zuup.entities.Car;
import com.sergim.zuup.service.CarService;

@RestController
@RequestMapping(value = "/cars")
public class CarResource {



	@Autowired
	private CarService services;
	
	@GetMapping
	public ResponseEntity<List<CarDriverDTO>> findAll(){
		List<CarDriverDTO> list = services.findAllCarWithDriver();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CarDTO> findById(@PathVariable long id){
		CarDTO car = services.findById(id);
		return ResponseEntity.ok(car);
	}

	@GetMapping(value = "/{id}/driver")
	public ResponseEntity<CarDriverDTO> findCarWithDriver(@PathVariable long id){
		CarDriverDTO cars = services.findByIdCarWithDriver(id);
		return ResponseEntity.ok(cars);
	}
	

	//@PostMapping
/*	public ResponseEntity<CarDriverDTO> insert(@RequestBody CarDriverDTO obj){
		   obj = services.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj);
	}
*/
	@PostMapping
	public ResponseEntity<CarDTO> insert(@RequestBody CarDTO obj){
		obj = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Car> delete(@PathVariable Long id){
		services.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CarDriverDTO> update(@PathVariable Long id, @RequestBody CarDriverDTO obj){
		obj = services.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
