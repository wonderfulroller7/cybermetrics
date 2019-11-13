package com.nyu.cybermetrics.repositories;

import com.nyu.cybermetrics.entities.SurveyResponseEntity;
import com.nyu.cybermetrics.entities.SurveyResponseIndexEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface SurveyIndexRepository extends CrudRepository<SurveyResponseIndexEntity, Long> {

    @Query(value = "select DISTINCT u.date from survey u",
            nativeQuery = true)
    List<Timestamp> findAllTimestamps();
}
