package com.nyu.cybermetrics.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.nyu.cybermetrics.dtos.*;
import com.nyu.cybermetrics.entities.SurveyResponseEntity;
import com.nyu.cybermetrics.repositories.SurveyRepository;
import com.nyu.cybermetrics.repositories.SurveyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SurveyDataService {

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    SurveyTypeRepository surveyTypeRepository;

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
}
