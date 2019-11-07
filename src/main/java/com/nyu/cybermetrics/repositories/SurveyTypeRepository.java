package com.nyu.cybermetrics.repositories;

import com.nyu.cybermetrics.entities.CVEEntity;
import com.nyu.cybermetrics.entities.SurveyResponseEntity;
import com.nyu.cybermetrics.entities.SurveyResponseIndexEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class SurveyTypeRepository {

    @Autowired
    EntityManager em;

    public int findCount(String fieldName, String fieldValue, String month, String year) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SurveyResponseEntity> cq = cb.createQuery(SurveyResponseEntity.class);

        Root<SurveyResponseEntity> surveyResponse = cq.from(SurveyResponseEntity.class);
        Predicate authorNamePredicate = cb.equal(surveyResponse.get(fieldName), fieldValue.toUpperCase());
        Predicate monthPredicate = cb.equal(cb.function("MONTH", Integer.class, surveyResponse.get("date")), month);
        Predicate yearPredicate = cb.equal(cb.function("YEAR", Integer.class, surveyResponse.get("date")), year);
        cq.where(authorNamePredicate, monthPredicate, yearPredicate);

        TypedQuery<SurveyResponseEntity> query = em.createQuery(cq);
        return query.getResultList().size();
    }

    public double getSubIndexByTopicPerMonth(String fieldName, String month, String year) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SurveyResponseIndexEntity> cq = cb.createQuery(SurveyResponseIndexEntity.class);

        Root<SurveyResponseIndexEntity> surveyResponse = cq.from(SurveyResponseIndexEntity.class);
        Predicate monthPredicate = cb.equal(cb.function("MONTH", Integer.class, surveyResponse.get("date")), month);
        Predicate yearPredicate = cb.equal(cb.function("YEAR", Integer.class, surveyResponse.get("date")), year);
        cq.where(monthPredicate, yearPredicate);
        cq.select(cb.construct(SurveyResponseIndexEntity.class, surveyResponse.get(fieldName)));
        try{
            TypedQuery<SurveyResponseIndexEntity> query = em.createQuery(cq);
            return query.getResultList().get(0).getField();
        } catch(Exception e) {
            return -1;
        }
    }

    public HashMap<Date, Double> getSubindexForEveryMonth(String fieldName) {

        HashMap<Date, Double> subIndexByMonth = new HashMap<Date, Double>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SurveyResponseIndexEntity> cq = cb.createQuery(SurveyResponseIndexEntity.class);

        Root<SurveyResponseIndexEntity> surveyResponse = cq.from(SurveyResponseIndexEntity.class);
        cq.select(cb.construct(SurveyResponseIndexEntity.class, surveyResponse.get(fieldName), surveyResponse.get("date")));
        try {
            TypedQuery<SurveyResponseIndexEntity> query = em.createQuery(cq);
            List<SurveyResponseIndexEntity> indexes = query.getResultList();
            for (SurveyResponseIndexEntity index: indexes) {
                subIndexByMonth.put(index.getDate_of_field() , index.getField());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return subIndexByMonth;
    }

    public List<CVEEntity> getCVESWithFilterPerMonthPerYear(String month, String year) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CVEEntity> cq = cb.createQuery(CVEEntity.class);

        Root<CVEEntity> cveLinks = cq.from(CVEEntity.class);
        Predicate monthPredicate = cb.equal(cb.function("MONTH", Integer.class, cveLinks.get("published_date")), month);
        Predicate yearPredicate = cb.equal(cb.function("YEAR", Integer.class, cveLinks.get("published_date")), year);
        cq.where(monthPredicate, yearPredicate);
        //cq.select(cb.construct(CVEEntity.class, cveLinks.get("cveid")));
        try{
            TypedQuery<CVEEntity> query = em.createQuery(cq);
            return query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
