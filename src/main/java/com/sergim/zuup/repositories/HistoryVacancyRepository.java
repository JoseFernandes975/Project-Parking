package com.sergim.zuup.repositories;

import com.sergim.zuup.entities.HistoryVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryVacancyRepository extends JpaRepository<HistoryVacancy, Long> {
}
