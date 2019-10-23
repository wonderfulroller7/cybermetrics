package com.nyu.cybermetrics.controllers;

import com.nyu.cybermetrics.dtos.SurveyResponseDto;
import com.nyu.cybermetrics.services.SurveyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SurveyDataController {

    @Autowired
    SurveyDataService surveyDataService;


    @RequestMapping(value="/api/getSurveyData/{year}/{month}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getSurveyData(@PathVariable("month") String month, @PathVariable("year") String year) {

        ArrayList<SurveyResponseDto> surveys = surveyDataService.getSurveysByMonth(month, year);
        return ResponseEntity.ok(surveys);
    }

    @RequestMapping(value="/api/getSurveyDataByMonth/{year}/{month}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getSurveyDataByMonth(@PathVariable("month") String month, @PathVariable("year") String year) {

        return ResponseEntity.ok(surveyDataService.getSurveyCalculationsByMonth(month, year));
    }

    @RequestMapping(value="/api/getSurveyDataByMonth/{year}/{month}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> get(@PathVariable("month") String month, @PathVariable("year") String year) {

        return ResponseEntity.ok(surveyDataService.getSurveyCalculationsByMonth(month, year));
    }



}
