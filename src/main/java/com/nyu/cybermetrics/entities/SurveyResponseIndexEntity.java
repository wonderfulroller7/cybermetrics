package com.nyu.cybermetrics.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "survey_index_monthly")
public class SurveyResponseIndexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp date;
    private float insider_threat;
    private float strategic_rivals;
    private float activist_hacktivist;
    private float criminals;
    private float nation_states;
    private float web_facing_applications;
    private float internet_exposed_devices;
    private float end_points;
    private float mobile_devices;
    private float public_infrastructure_or_cloud;
    private float counterparties;
    private float autonomous_network_connected_devices;
    private float vulnerability_to_known_threats;
    private float vulnerability_to_unknown_threats;
    private float data_theft;
    private float data_modification;
    private float business_disruption;
    private float false_claims_of_digital_identity;
    private float media_public_perception;
    private float personal_risk;
    private float botnets;
    private float mass_malware;
    private float vulnerability;
    private float phishing_social_engineering;
    private float customized_to_target;

    private boolean calculate;

    public SurveyResponseIndexEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public float getInsider_threat() {
        return insider_threat;
    }

    public void setInsider_threat(float insider_threat) {
        this.insider_threat = insider_threat;
    }

    public float getStrategic_rivals() {
        return strategic_rivals;
    }

    public void setStrategic_rivals(float strategic_rivals) {
        this.strategic_rivals = strategic_rivals;
    }

    public float getActivist_hacktivist() {
        return activist_hacktivist;
    }

    public void setActivist_hacktivist(float activist_hacktivist) {
        this.activist_hacktivist = activist_hacktivist;
    }

    public float getCriminals() {
        return criminals;
    }

    public void setCriminals(float criminals) {
        this.criminals = criminals;
    }

    public float getNation_states() {
        return nation_states;
    }

    public void setNation_states(float nation_states) {
        this.nation_states = nation_states;
    }

    public float getWeb_facing_applications() {
        return web_facing_applications;
    }

    public void setWeb_facing_applications(float web_facing_applications) {
        this.web_facing_applications = web_facing_applications;
    }

    public float getInternet_exposed_devices() {
        return internet_exposed_devices;
    }

    public void setInternet_exposed_devices(float internet_exposed_devices) {
        this.internet_exposed_devices = internet_exposed_devices;
    }

    public float getEnd_points() {
        return end_points;
    }

    public void setEnd_points(float end_points) {
        this.end_points = end_points;
    }

    public float getMobile_devices() {
        return mobile_devices;
    }

    public void setMobile_devices(float mobile_devices) {
        this.mobile_devices = mobile_devices;
    }

    public float getPublic_infrastructure_or_cloud() {
        return public_infrastructure_or_cloud;
    }

    public void setPublic_infrastructure_or_cloud(float public_infrastructure_or_cloud) {
        this.public_infrastructure_or_cloud = public_infrastructure_or_cloud;
    }

    public float getCounterparties() {
        return counterparties;
    }

    public void setCounterparties(float counterparties) {
        this.counterparties = counterparties;
    }

    public float getAutonomous_network_connected_devices() {
        return autonomous_network_connected_devices;
    }

    public void setAutonomous_network_connected_devices(float autonomous_network_connected_devices) {
        this.autonomous_network_connected_devices = autonomous_network_connected_devices;
    }

    public float getVulnerability_to_known_threats() {
        return vulnerability_to_known_threats;
    }

    public void setVulnerability_to_known_threats(float vulnerability_to_known_threats) {
        this.vulnerability_to_known_threats = vulnerability_to_known_threats;
    }

    public float getVulnerability_to_unknown_threats() {
        return vulnerability_to_unknown_threats;
    }

    public void setVulnerability_to_unknown_threats(float vulnerability_to_unknown_threats) {
        this.vulnerability_to_unknown_threats = vulnerability_to_unknown_threats;
    }

    public float getData_theft() {
        return data_theft;
    }

    public void setData_theft(float data_theft) {
        this.data_theft = data_theft;
    }

    public float getData_modification() {
        return data_modification;
    }

    public void setData_modification(float data_modification) {
        this.data_modification = data_modification;
    }

    public float getBusiness_disruption() {
        return business_disruption;
    }

    public void setBusiness_disruption(float business_disruption) {
        this.business_disruption = business_disruption;
    }

    public float getFalse_claims_of_digital_identity() {
        return false_claims_of_digital_identity;
    }

    public void setFalse_claims_of_digital_identity(float false_claims_of_digital_identity) {
        this.false_claims_of_digital_identity = false_claims_of_digital_identity;
    }

    public float getMedia_public_perception() {
        return media_public_perception;
    }

    public void setMedia_public_perception(float media_public_perception) {
        this.media_public_perception = media_public_perception;
    }

    public float getPersonal_risk() {
        return personal_risk;
    }

    public void setPersonal_risk(float personal_risk) {
        this.personal_risk = personal_risk;
    }

    public float getBotnets() {
        return botnets;
    }

    public void setBotnets(float botnets) {
        this.botnets = botnets;
    }

    public float getMass_malware() {
        return mass_malware;
    }

    public void setMass_malware(float mass_malware) {
        this.mass_malware = mass_malware;
    }

    public float getVulnerability() {
        return vulnerability;
    }

    public void setVulnerability(float vulnerability) {
        this.vulnerability = vulnerability;
    }

    public float getPhishing_social_engineering() {
        return phishing_social_engineering;
    }

    public void setPhishing_social_engineering(float phishing_social_engineering) {
        this.phishing_social_engineering = phishing_social_engineering;
    }

    public float getCustomized_to_target() {
        return customized_to_target;
    }

    public void setCustomized_to_target(float customized_to_target) {
        this.customized_to_target = customized_to_target;
    }

    public boolean isCalculate() {
        return calculate;
    }

    public void setCalculate(boolean calculate) {
        this.calculate = calculate;
    }

    @Override
    public String toString() {
        return "SurveyResponseIndexEntity{" +
                "id=" + id +
                ", date=" + date +
                ", insider_threat=" + insider_threat +
                ", strategic_rivals=" + strategic_rivals +
                ", activist_hacktivist=" + activist_hacktivist +
                ", criminals=" + criminals +
                ", nation_states=" + nation_states +
                ", web_facing_applications=" + web_facing_applications +
                ", internet_exposed_devices=" + internet_exposed_devices +
                ", end_points=" + end_points +
                ", mobile_devices=" + mobile_devices +
                ", public_infrastructure_or_cloud=" + public_infrastructure_or_cloud +
                ", counterparties=" + counterparties +
                ", autonomous_network_connected_devices=" + autonomous_network_connected_devices +
                ", vulnerability_to_known_threats=" + vulnerability_to_known_threats +
                ", vulnerability_to_unknown_threats=" + vulnerability_to_unknown_threats +
                ", data_theft=" + data_theft +
                ", data_modification=" + data_modification +
                ", business_disruption=" + business_disruption +
                ", false_claims_of_digital_identity=" + false_claims_of_digital_identity +
                ", media_public_perception=" + media_public_perception +
                ", personal_risk=" + personal_risk +
                ", botnets=" + botnets +
                ", mass_malware=" + mass_malware +
                ", vulnerability=" + vulnerability +
                ", phishing_social_engineering=" + phishing_social_engineering +
                ", customized_to_target=" + customized_to_target +
                ", calculate=" + calculate +
                '}';
    }
}
