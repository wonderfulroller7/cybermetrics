package com.nyu.cybermetrics.repositories;

import com.nyu.cybermetrics.entities.CVEEntity;
import com.nyu.cybermetrics.entities.SurveyResponseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CVERepository extends CrudRepository<CVEEntity, String> {

    @Query(value = "select * from cve_data u where MONTH(u.published_date) = :month and YEAR(u.published_date) = :year",
            nativeQuery = true)
    List<CVEEntity> findByMonth(String month, String year);

}
