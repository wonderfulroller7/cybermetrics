package com.nyu.cybermetrics.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.nyu.cybermetrics.dtos.*;
import com.nyu.cybermetrics.entities.CVEEntity;
import com.nyu.cybermetrics.entities.SurveyResponseEntity;
import com.nyu.cybermetrics.entities.SurveyResponseIndexEntity;
import com.nyu.cybermetrics.repositories.CVERepository;
import com.nyu.cybermetrics.repositories.SurveyIndexRepository;
import com.nyu.cybermetrics.repositories.SurveyRepository;
import com.nyu.cybermetrics.repositories.SurveyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class SurveyDataService {

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    SurveyTypeRepository surveyTypeRepository;

    @Autowired
    SurveyIndexRepository surveyIndexRepository;

    @Autowired
    CVERepository cveRepository;

    /**
     * Identify the survey month by month
     * @param month
     * @param year
     * @return
     */
    public ArrayList<SurveyResponseDto> getSurveysByMonth(String month, String year) {

        ArrayList<SurveyResponseDto> surveyResponseDtos = new ArrayList<SurveyResponseDto>();
        List<SurveyResponseEntity> lists = surveyRepository.findByMonth(month, year);
        for (SurveyResponseEntity entity: lists) {
            SurveyResponseDto responseDto = new SurveyResponseDto();
            responseDto.setDate(entity.getDate());
            AttackActors attackActors = new AttackActors(entity.getInsider_threat(),
                                                        entity.getStrategic_rivals(),entity.getActivist_hacktivist(),
                                                        entity.getCriminals(), entity.getNation_states());
            AttackTargets attackTargets = new AttackTargets(entity.getWeb_facing_applications(), entity.getInternet_exposed_devices(),
                                                            entity.getEnd_points(), entity.getMobile_devices(),
                                                            entity.getPublic_infrastructure_or_cloud(), entity.getCounterparties(),
                                                            entity.getAutonomous_network_connected_devices());
            Defenses defenses = new Defenses(entity.getVulnerability_to_known_threats(),
                                            entity.getVulnerability_to_unknown_threats());
            Effects effects = new Effects(entity.getData_theft(), entity.getData_modification(), entity.getBusiness_disruption());
            OverallPerceptions overallPerceptions = new OverallPerceptions(entity.getFalse_claims_of_digital_identity(),
                    entity.getMedia_public_perception(), entity.getPersonal_risk());
            Weapons weapons = new Weapons(entity.getBotnets(), entity.getMass_malware(),
                    entity.getVulnerability(), entity.getPhishing_social_engineering(), entity.getCustomized_to_target());
            surveyResponseDtos.add(responseDto);
        }
        return surveyResponseDtos;
    }

    public void getDatesOfSurvey() {

        ArrayList<Timestamp> dates = surveyRepository.findAllDates();
        for (Timestamp date: dates) {
            System.out.println(date.toString());
        }
    }
    /**
     * Get all Survey calculations by Month
     * @param month
     * @param year
     * @return
     */
    public ArrayList<FieldCountDto> getSurveyCalculationsByMonth(String month, String year) {

        ArrayList<FieldCountDto> fieldCountDtos = new ArrayList<FieldCountDto>();
        if (Integer.parseInt(year) < 2015 || Integer.parseInt(month) < 2) {
            System.out.println("Month = " + month + " Year = " + year);
            FieldCountDto dto = null;
            return fieldCountDtos;
        }
        try{
            ObjectMapper mapper = new ObjectMapper();
            File resource = new ClassPathResource("data/metric_map.json").getFile();
            fieldCountDtos = mapper.readValue(resource, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class,
                                                FieldCountDto.class));
            for (FieldCountDto dto: fieldCountDtos) {
                String map = dto.getMap();
                dto.setSame(surveyTypeRepository.findCount(map, "static", month, year));
                dto.setRisen(surveyTypeRepository.findCount(map, "risen", month, year));
                dto.setFallen(surveyTypeRepository.findCount(map, "fallen", month, year));
                dto.setFallen_fast(surveyTypeRepository.findCount(map, "fallen fast", month, year));
                dto.setRisen_fast(surveyTypeRepository.findCount(map, "risen fast", month, year));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return fieldCountDtos;
    }

    public double getSubIndexByTopicPerMonth(String topic, String month, String year) {

        return surveyTypeRepository.getSubIndexByTopicPerMonth(topic, month, year);
    }

    public TreeMap<String, String> getSubindexForEveryMonth(String topic) {

        HashMap<Date, Double> map = surveyTypeRepository.getSubindexForEveryMonth(topic);
        TreeMap<String, String> queryMap = new TreeMap<>();
        for (Date date: map.keySet()) {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year  = localDate.getYear();
            int month = localDate.getMonthValue();
            if (month < 10) {
                queryMap.put(String.valueOf(year) + "-0" + String.valueOf(month), String.valueOf(map.get(date)));
            } else {
                queryMap.put(String.valueOf(year) + "-" + String.valueOf(month), String.valueOf(map.get(date)));
            }

        }
        return queryMap;
    }

    public TreeMap<String, String> getSubindexByDifferenceForEveryMonth(String topic) {

        HashMap<Date, Double> map = surveyTypeRepository.getSubindexForEveryMonth(topic);

        TreeMap<String, String> queryMap = new TreeMap<>();
        for (Date date : map.keySet()) {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            if (month < 10) {
                queryMap.put(String.valueOf(year) + "-0" + String.valueOf(month), String.valueOf(map.get(date)));
            } else {
                queryMap.put(String.valueOf(year) + "-" + String.valueOf(month), String.valueOf(map.get(date)));
            }
        }
        TreeMap<String, String> diffrentialMap = new TreeMap<>();
        List<String> dates = new ArrayList<String>();
        dates.addAll(queryMap.keySet());
        for (int loop = 1; loop < dates.size(); loop++) {
            double prev = Double.valueOf(queryMap.get(dates.get(loop - 1)));
            double curr = Double.valueOf(queryMap.get(dates.get(loop)));
            double differential = ((curr - prev) / prev) * 100;
            diffrentialMap.put(dates.get(loop), String.valueOf(differential));
        }
        return diffrentialMap;
    }

    public List<CVEEntity> getCVEDataPerMonthAndYear(String month, String year) {

        List<CVEEntity> cveEntitiesPerMonth = cveRepository.findByMonth(month, year);
        return cveEntitiesPerMonth;
    }

    // get chart labels
    public List<String> getChartLabels() {

        List<String> dates_list = new ArrayList<String>();
        List<Timestamp> dates = surveyIndexRepository.findAllTimestamps();
        for (Timestamp date: dates) {
            Date temp = new Date();
            temp.setTime(date.getTime());
            String formattedDate = new SimpleDateFormat("MMM-yyyy").format(temp);
            dates_list.add(formattedDate);
        }
        return dates_list;
    }

    // Get month back by month and year
    private List<String> getChartLabelsMonthYear() {
        List<String> dates_list = new ArrayList<String>();
        List<Timestamp> dates = surveyIndexRepository.findAllTimestamps();
        for (Timestamp date: dates) {
            Date temp = new Date();
            temp.setTime(date.getTime());
            String formattedDate = new SimpleDateFormat("MM yyyy").format(temp);
            dates_list.add(formattedDate);
        }
        return dates_list;
    }

    // get all chart data
    public ArrayList<ChartDto> chartMap(String choice) {

        String[] topics = {"activist_hacktivist", "criminals","nation_states", 
                "web_facing_applications","internet_exposed_devices","end_points",
                "mobile_devices","public_infrastructure_or_cloud","counterparties",
                "autonomous_network_connected_devices","vulnerability_to_known_threats",
                "vulnerability_to_unknown_threats","data_theft","data_modification",
                "business_disruption","false_claims_of_digital_identity","media_public_perception",
                "personal_risk","botnets","mass_malware","vulnerability",
                "phishing_social_engineering","customized_to_target"
        };
        ArrayList<ChartDto> objects = new ArrayList<ChartDto>();
        if (choice.equalsIgnoreCase("all")) {
            for (String topic: topics) {
                ChartDto temp = new ChartDto();
                temp.setLabel(topic);
                TreeMap<String, String> tempList = getSubindexForEveryMonth(topic);
                for (String val: tempList.keySet()) {
                    String key_value = tempList.get(val);
                    if (key_value.equalsIgnoreCase("0.0"))
                        key_value = "1000.0";
                    temp.getData().add(Double.valueOf(key_value));
                }
                objects.add(temp);
            }
        } else {
            ChartDto temp = new ChartDto();
            temp.setLabel(choice);
            TreeMap<String, String> tempList = getSubindexForEveryMonth(choice);
            for (String val: tempList.keySet()) {
                String key_value = tempList.get(val);
                if (key_value.equalsIgnoreCase("0.0"))
                    key_value = "1000.0";
                temp.getData().add(Double.valueOf(key_value));
            }
            objects.add(temp);
        }
        List<String> monthYearList = getChartLabelsMonthYear();
        ChartDto cve_data = new ChartDto();
        for (String date: monthYearList) {
            String[] temp = date.split(" ");
            cve_data.getData().add((double)getCVEDataPerMonthAndYear(temp[0], temp[1]).size());
        }
        cve_data.setLabel("CVE");
        cve_data.setyAxisID("B");
        objects.add(cve_data);
        return objects;
    }

    public ArrayList<ChartDto> getIndexValue() {
        ArrayList<ChartDto> objects = new ArrayList<ChartDto>();
        String[] topics = {"activist_hacktivist", "criminals","nation_states",
                "web_facing_applications","internet_exposed_devices","end_points",
                "mobile_devices","public_infrastructure_or_cloud","counterparties",
                "autonomous_network_connected_devices","vulnerability_to_known_threats",
                "vulnerability_to_unknown_threats","data_theft","data_modification",
                "business_disruption","false_claims_of_digital_identity","media_public_perception",
                "personal_risk","botnets","mass_malware","vulnerability",
                "phishing_social_engineering","customized_to_target"
        };
//        CVSS.Weight = {
//        AV:   { N: 0.85,  A: 0.62,  L: 0.55,  P: 0.2},
//        AC:   { H: 0.44,  L: 0.77},
//        PR:   { U:       {N: 0.85,  L: 0.62,  H: 0.27},         // These values are used if Scope is Unchanged
//
//        C:       {N: 0.85,  L: 0.68,  H: 0.5}},         // These values are used if Scope is Changed
//        UI:   { N: 0.85,  R: 0.62},
//        S:    { U: 6.42,  C: 7.52},                             // Note: not defined as constants in specification
//        CIA:  { N: 0,     L: 0.22,  H: 0.56},                   // C, I and A have the same weights
//
//        E:    { X: 1,     U: 0.91,  P: 0.94,  F: 0.97,  H: 1},
//        RL:   { X: 1,     O: 0.95,  T: 0.96,  W: 0.97,  U: 1},
//        RC:   { X: 1,     U: 0.92,  R: 0.96,  C: 1},
//
//        CIAR: { X: 1,     L: 0.5,   M: 1,     H: 1.5}           // CR, IR and AR have the same weights
//        };

        String[] values = {"RISEN", "RISEN_FAST", "FALLEN", "FALLEN_FAST", "STATIC"};
        List<String> chartLabelMonthYear = getChartLabelsMonthYear();
        for (String date: chartLabelMonthYear) {
            String[] temp = date.split(" ");
            for (String topic: topics) {
                for (String value: values) {
                    long value_count = surveyTypeRepository.findCount(topic, value, temp[0], temp[1]);
                    System.out.println(topic + ":" + value + ":" +date + ":" + value_count);
                }
            }
        }

        return objects;
    }

}
