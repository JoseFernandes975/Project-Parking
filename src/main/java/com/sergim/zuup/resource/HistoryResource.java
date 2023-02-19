package com.sergim.zuup.resource;

import com.sergim.zuup.entities.HistoryVacancy;
import com.sergim.zuup.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/historic")
public class HistoryResource {

    @Autowired
    private HistoryService service;

    @GetMapping
    public ResponseEntity<List<HistoryVacancy>> findAll(){
        List<HistoryVacancy> list = service.findAllHistorys();
        return ResponseEntity.ok(list);
    }
}
