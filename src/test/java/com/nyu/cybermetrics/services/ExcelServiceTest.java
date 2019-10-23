package com.nyu.cybermetrics.services;

import com.nyu.cybermetrics.CybermetricsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= CybermetricsApplication.class)
@AutoConfigureMockMvc
public class ExcelServiceTest {

    @Autowired
    private ExcelService excelService;

    @Test
    public void insertSurveyIndexData() {
        excelService.indexCalculation();
    }
}
