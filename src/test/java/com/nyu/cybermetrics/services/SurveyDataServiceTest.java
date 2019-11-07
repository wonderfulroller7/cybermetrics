package com.nyu.cybermetrics.services;

import com.nyu.cybermetrics.CybermetricsApplication;
import com.nyu.cybermetrics.entities.CVEEntity;
import com.nyu.cybermetrics.repositories.SurveyTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= CybermetricsApplication.class)
@AutoConfigureMockMvc
public class SurveyDataServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SurveyDataService surveyDataService;

    @Autowired
    private SurveyTypeRepository surveyTypeRepository;

    @Test
    public void getSurveyCalculationsByMonthTest() throws Exception {

        surveyDataService.getSurveyCalculationsByMonth("2", "2017");
        surveyDataService.getSurveyCalculationsByMonth("3", "2017");
    }

    @Test
    public void getCVESByMonthAndYear() throws Exception {
        List<CVEEntity> cveEntities = surveyTypeRepository.getCVESWithFilterPerMonthPerYear("5", "2011");
        for (CVEEntity entity: cveEntities) {
            System.out.println(entity);
        }
    }
}
