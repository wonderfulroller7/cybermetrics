package com.nyu.cybermetrics.repositories;

import com.nyu.cybermetrics.entities.SurveyResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
}
