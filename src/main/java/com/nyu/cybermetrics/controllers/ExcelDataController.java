package com.nyu.cybermetrics.controllers;

import com.nyu.cybermetrics.services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ExcelDataController {

    @Autowired
    ExcelService excelService;

    @RequestMapping(value="/api/getSheets", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getSheets() {

        ArrayList<String> sheets = excelService.getSheets();
        return ResponseEntity.ok(sheets);
    }

    @RequestMapping(value="/api/get_Paste_Report_Here", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getPaste_Report_Here() {

        HashMap<String, Integer> sheets = excelService.Paste_Report_Here();
        return ResponseEntity.ok(sheets);
    }




}
