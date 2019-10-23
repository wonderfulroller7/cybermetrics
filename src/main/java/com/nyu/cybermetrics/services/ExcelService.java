package com.nyu.cybermetrics.services;

import com.nyu.cybermetrics.dtos.*;
import com.nyu.cybermetrics.entities.SurveyResponseEntity;
import com.nyu.cybermetrics.entities.SurveyResponseIndexEntity;
import com.nyu.cybermetrics.repositories.SurveyIndexRepository;
import com.nyu.cybermetrics.repositories.SurveyRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.*;

@Service
public class ExcelService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyIndexRepository surveyIndexRepository;

    public ArrayList<String> getSheets() {

        ArrayList<String> lists = new ArrayList<String>();
        try {
            Workbook wb = getWorkBook();
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                lists.add(wb.getSheetAt(i).getSheetName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lists;
    }

    // Paste_Report_Here
    public HashMap<String, Integer> Paste_Report_Here() {

        HashMap<String, Integer> indexes = new HashMap<String, Integer>();
        Workbook wb = getWorkBook();
        Sheet sheet = wb.getSheet("Paste_Report_Here");
        int rows = sheet.getLastRowNum();
        int last_column = sheet.getRow(0).getLastCellNum();
        Row row = sheet.getRow(0);
        if (null != getCell(row, 0)) {
            for (int loop = 5; loop < last_column; loop++) {
                try {
                    indexes.put(row.getCell(loop).getStringCellValue().trim(), loop);
                } catch (NullPointerException e1) {
                    //System.err.println("Null Pointer at cell "+ row.getCell(loop).getAddress().toString());
                    continue;
                }
            }
        }
        ArrayList<SurveyResponseDto> surveyResponseDtos = new ArrayList<SurveyResponseDto>();
        String value = "";
        for (int i = 1; i < rows; i++) {
            row = sheet.getRow(i);
            SurveyResponseDto surveyResponseDto = new SurveyResponseDto();
            if (null != row && null != row.getCell(4) && null != row.getCell(5)) {
                try {
                    Date date = row.getCell(4).getDateCellValue();
                    SurveyResponseEntity surveyResponseEntity = new SurveyResponseEntity();
                    surveyResponseEntity.setDate(new Timestamp(date.getTime()));
                    surveyResponseEntity.setInsider_threat(row.getCell(5).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setStrategic_rivals(row.getCell(6).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setActivist_hacktivist(row.getCell(7).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setCriminals(row.getCell(8).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setNation_states(row.getCell(9).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setBotnets(row.getCell(10).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setMass_malware(row.getCell(11).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setVulnerability(row.getCell(12).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setPhishing_social_engineering(row.getCell(13).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setCustomized_to_target(row.getCell(14).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setData_theft(row.getCell(15).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setData_modification(row.getCell(16).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setBusiness_disruption(row.getCell(17).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setWeb_facing_applications(row.getCell(18).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setInternet_exposed_devices(row.getCell(19).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setEnd_points(row.getCell(20).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setMobile_devices(row.getCell(21).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setPublic_infrastructure_or_cloud(row.getCell(22).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setCounterparties(row.getCell(23).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setAutonomous_network_connected_devices(row.getCell(24).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setVulnerability_to_known_threats(row.getCell(25).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setVulnerability_to_unknown_threats(row.getCell(26).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setFalse_claims_of_digital_identity(row.getCell(27).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setMedia_public_perception(row.getCell(28).getStringCellValue().trim().toUpperCase());
                    surveyResponseEntity.setPersonal_risk(row.getCell(29).getStringCellValue().trim().toUpperCase());
                    surveyRepository.save(surveyResponseEntity);
                    //surveyResponseDtos.add(surveyResponseDto);
                } catch (Exception e) {
                    System.err.println(i + "-->" + e.getMessage());
                    //e.printStackTrace();
                }
            } else {
                continue;
            }
        }
        return indexes;
    }

    // Calcs Sheet
    private void calcs() {

    }

    // Index_CALCULATION Sheet
    public ArrayList<SurveyResponseIndexEntity> indexCalculation() {

        Workbook wb = getWorkBook();
        Sheet sheet = wb.getSheet("Index_CALCULATION");
        int first_row = 15;
        int start_column = 16;
        Row date_row = sheet.getRow(14);
        ArrayList<SurveyResponseIndexEntity> indexes = new ArrayList<SurveyResponseIndexEntity>();
        while(null != getCell(date_row,start_column)) {
            Date date = date_row.getCell(start_column).getDateCellValue();
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date);
            int loop = first_row;
            System.out.println(date.toString());
            SurveyResponseIndexEntity entity = new SurveyResponseIndexEntity();
            entity.setDate(new Timestamp(date.getTime()));
            Row row = sheet.getRow(loop++);
            entity.setInsider_threat(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setStrategic_rivals(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setActivist_hacktivist(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setCriminals(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setNation_states(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setBotnets(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setMass_malware(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setVulnerability(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setPhishing_social_engineering(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setCustomized_to_target(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setData_theft(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setData_modification(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setBusiness_disruption(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setWeb_facing_applications(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setInternet_exposed_devices(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setEnd_points(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setMobile_devices(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setPublic_infrastructure_or_cloud(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setCounterparties(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setAutonomous_network_connected_devices(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setVulnerability_to_known_threats(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setVulnerability_to_unknown_threats(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setFalse_claims_of_digital_identity(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setMedia_public_perception(getCell(row, start_column).getNumericCellValue());
            row = sheet.getRow(loop++);
            entity.setPersonal_risk(getCell(row, start_column).getNumericCellValue());
            surveyIndexRepository.save(entity);
            indexes.add(entity);
            start_column++;
        }
        return indexes;
    }

    // alpha-beta Sheet
    private void alphaBeta() {

    }

    // Rolling 12 mos
    private void rollingTwelveMonths() {

    }

    // main_chart
    private void mainChart() {

    }

    // subindex_charts
    private void subindexCharts() {

    }

    // diffusion_charts
    private void diffusionCharts() {

    }

    // Q_of_the_mth
    private void qOfTheMonth() {

    }

    // mappings
    private void mappings() {

    }

    private Workbook getWorkBook() {
        Workbook wb = null;
        try{
            File resource = new ClassPathResource("data/August_2019.xlsx").getFile();
            InputStream input = new FileInputStream(resource);
            wb = WorkbookFactory.create(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wb;
    }

    // Cell and Row Null checks
    private Cell getCell (Row row, int index) {

        if (null!= row && null != row.getCell(index))
            return row.getCell(index);
        else
            return null;
    }
}
