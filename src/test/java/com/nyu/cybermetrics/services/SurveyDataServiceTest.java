package com.nyu.cybermetrics.services;

import com.nyu.cybermetrics.CybermetricsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= CybermetricsApplication.class)
@AutoConfigureMockMvc
public class SurveyDataServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SurveyDataService surveyDataService;

    @Test
    public void getSurveyCalculationsByMonthTest() throws Exception {

        surveyDataService.getSurveyCalculationsByMonth("2", "2017");
        surveyDataService.getSurveyCalculationsByMonth("3", "2017");
    }
}
