package com.nyu.cybermetrics.repositories;

import com.nyu.cybermetrics.entities.SurveyResponseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface SurveyRepository extends CrudRepository<SurveyResponseEntity, Long> {

    @Query(value = "select * from survey u where MONTH(u.date) = :month and YEAR(u.date) = :year",
            nativeQuery = true)
    List<SurveyResponseEntity> findByMonth(String month, String year);

    @Query(value = "select * from survey u where YEAR(u.date) = :year",
            nativeQuery = true)
    List<SurveyResponseEntity> findByYear(String year);

    @Query(value = "select DISTINCT(u.date) from survey u", nativeQuery = true)
    ArrayList<Timestamp> findAllDates();
}
