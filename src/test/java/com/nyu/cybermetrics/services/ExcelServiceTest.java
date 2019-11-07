package com.nyu.cybermetrics.services;

import com.nyu.cybermetrics.CybermetricsApplication;
import org.json.simple.JSONObject;
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

    @Autowired
    private JSONService jsonService;

    @Test
    public void insertSurveyIndexData() {
        excelService.indexCalculation();
    }

    @Test
    public void jsonServiceTest() {
//        jsonService.NVDDataParser("nvdcve-1.1-2011.json");
//        jsonService.NVDDataParser("nvdcve-1.1-2012.json");
//        jsonService.NVDDataParser("nvdcve-1.1-2013.json");
//        jsonService.NVDDataParser("nvdcve-1.1-2014.json");
        jsonService.NVDDataParser("nvdcve-1.1-2015.json");
        jsonService.NVDDataParser("nvdcve-1.1-2016.json");
        jsonService.NVDDataParser("nvdcve-1.1-2017.json");
        jsonService.NVDDataParser("nvdcve-1.1-2018.json");
        //jsonService.NVDDataParser("nvdcve-1.1-2019.json");
    }
}
