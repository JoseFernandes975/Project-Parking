package com.sergim.zuup.service;

import com.sergim.zuup.dto.VacancyDTO;
import com.sergim.zuup.entities.HistoryVacancy;
import com.sergim.zuup.entities.Vacancy;
import com.sergim.zuup.exception.ResourceNotFoundException;
import com.sergim.zuup.repositories.CarRepository;
import com.sergim.zuup.repositories.HistoryVacancyRepository;
import com.sergim.zuup.repositories.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class VacancyService {

    @Autowired
    private CarRepository repo;

    @Autowired
    private VacancyRepository repository;

    @Autowired
    private HistoryVacancyRepository historyRepo;

    @Transactional
    public VacancyDTO insertVacancy(VacancyDTO dto) {
            if (repository.count() < 10) {
                Vacancy vacancy = new Vacancy();
                vacancy.setId(dto.getId());
                vacancy.setCarId(dto.getCarId());
                //    Optional<Car> car = repo.findById(dto.getVehicleId());
                //    vacancy.setCarId(car.get().getId());
                vacancy.setMomentEnter(dto.getMomentEnter());
                vacancy.setMomentExit(dto.getMomentExit());
                repository.save(vacancy);
                HistoryVacancy obj = new HistoryVacancy(vacancy);
                historyRepo.save(obj);
                return new VacancyDTO(vacancy);
            }
            else {
                throw new ResourceNotFoundException("Vagas lotadas!");
            }
        }

        @Transactional
        public void deleteVacancy(Long id) {
            try {
                repository.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                throw new ResourceNotFoundException("Id Not Found!");
            }
        }

        @Transactional(readOnly = true)
        public List<VacancyDTO> findAllVacancys(){
        List<Vacancy> list = repository.findAll();
        System.out.println(repository.count());
        return list.stream().map(x -> new VacancyDTO(x)).toList();
        }

        public Double showPayroll(@PathVariable Long id, @PathVariable Double valuePerHour) throws ParseException {
        Optional<Vacancy> obj = repository.findById(id);
        Vacancy v = obj.get();
        Integer a = diff(v.getMomentEnter(), v.getMomentExit());
        Double b = payment(a,valuePerHour);
        System.out.println("Pagar? (S/N)");
        Scanner sc = new Scanner(System.in);
        char p = sc.next().charAt(0);
        if (p == 'S'){
            repository.deleteById(id);
        }
        return b;
        }


    public Integer diff(String momentEnter, String momentExit) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date d1 = sdf.parse(momentEnter);
        Date d2 = sdf.parse(momentExit);
        long diff = d1.getTime() - d2.getTime();
        int diffHours = (int) (diff / (60 * 60 * 1000) % 24);
        return diffHours;
    }

    public double payment(Integer diff, Double valueHour){
        return (double) diff * valueHour;
    }

}
