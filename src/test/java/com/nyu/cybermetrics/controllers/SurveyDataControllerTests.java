package com.nyu.cybermetrics.controllers;

import com.nyu.cybermetrics.CybermetricsApplication;
import com.nyu.cybermetrics.dtos.FieldCountDto;
import com.nyu.cybermetrics.services.SurveyDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= CybermetricsApplication.class)
@AutoConfigureMockMvc
public class SurveyDataControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SurveyDataService surveyDataService;

    @Test
    public void getSurveyCalculationsByMonthTest() {

        System.out.println("Month: 05, Year: 2017");
        ArrayList<FieldCountDto> dtos = surveyDataService.getSurveyCalculationsByMonth("5", "2017");
        for (FieldCountDto dto: dtos) {
            System.out.println(dto);
        }
        System.out.println("Month: 07, Year: 2018");
        dtos = surveyDataService.getSurveyCalculationsByMonth("7", "2018");
        for (FieldCountDto dto: dtos) {
            System.out.println(dto);
        }
    }
}
