package com.sergim.zuup.resource;

import java.net.URI;
import java.util.List;

import com.sergim.zuup.dto.CarDTO;
import com.sergim.zuup.dto.CarDriverDTO;
import com.sergim.zuup.dto.CarsDTO;
import com.sergim.zuup.dto.DriverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sergim.zuup.entities.Driver;
import com.sergim.zuup.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

   @Autowired
   private ClientService service;
   
   @GetMapping(value = "/{id}")
   public ResponseEntity<DriverDTO> findById(@PathVariable long id) {
	   DriverDTO obj = service.findById(id);
	   return ResponseEntity.ok(obj);
   }
   
   @GetMapping
   public ResponseEntity<List<DriverDTO>> findAll(){
	  List<DriverDTO> list = service.findAll();
	  return ResponseEntity.ok().body(list);
   }

   @GetMapping(value = "/{id}/cars")
   public ResponseEntity<List<CarsDTO>> findDriverCars(@PathVariable long id){
       List<CarsDTO> list = service.findDriverCarsById(id);
       return ResponseEntity.ok(list);
   }

   @PostMapping
   public ResponseEntity<DriverDTO> insert(@RequestBody DriverDTO obj){
          obj = service.insert(obj);
          URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
          return ResponseEntity.created(uri).body(obj);
   }

   @DeleteMapping(value = "/{id}")
    public ResponseEntity<Driver> delete(@PathVariable Long id){
       service.delete(id);
       return ResponseEntity.noContent().build();
   }

   @PutMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> update(@PathVariable Long id, @RequestBody DriverDTO obj){
       obj = service.update(id, obj);
       return ResponseEntity.ok().body(obj);
   }

}
