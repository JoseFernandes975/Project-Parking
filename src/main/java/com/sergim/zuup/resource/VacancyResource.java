package com.sergim.zuup.resource;

import com.sergim.zuup.dto.VacancyDTO;
import com.sergim.zuup.entities.Vacancy;
import com.sergim.zuup.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/vacancys")
public class VacancyResource {
    @Autowired
    private VacancyService service;

    @PostMapping
    public ResponseEntity<VacancyDTO> insert(@RequestBody VacancyDTO obj) throws ParseException {
        obj = service.insertVacancy(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VacancyDTO> delete(@PathVariable Long id){
        service.deleteVacancy(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/{valuePerHour}")
    public ResponseEntity<Double> showPayroll(@PathVariable Long id, @PathVariable Double valuePerHour) throws ParseException {
        Double result = service.showPayroll(id, valuePerHour);
      return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<VacancyDTO>> findAll(){
        List<VacancyDTO> list = service.findAllVacancys();
        return ResponseEntity.ok().body(list);
    }

}
