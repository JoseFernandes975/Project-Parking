package com.sergim.zuup.service;

import com.sergim.zuup.entities.HistoryVacancy;
import com.sergim.zuup.repositories.HistoryVacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryVacancyRepository repository;

    @Transactional(readOnly = true)
    public List<HistoryVacancy> findAllHistorys(){
        List<HistoryVacancy> list = repository.findAll();
        return list;
    }
}
