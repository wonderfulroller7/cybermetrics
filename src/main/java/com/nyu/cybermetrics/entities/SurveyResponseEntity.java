package com.nyu.cybermetrics.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "survey")
public class SurveyResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp date;
    private String insider_threat;
    private String strategic_rivals;
    private String activist_hacktivist;
    private String criminals;
    private String nation_states;
    private String web_facing_applications;
    private String internet_exposed_devices;
    private String end_points;
    private String mobile_devices;
    private String public_infrastructure_or_cloud;
    private String counterparties;
    private String autonomous_network_connected_devices;
    private String vulnerability_to_known_threats;
    private String vulnerability_to_unknown_threats;
    private String data_theft;
    private String data_modification;
    private String business_disruption;
    private String false_claims_of_digital_identity;
    private String media_public_perception;
    private String personal_risk;
    private String botnets;
    private String mass_malware;
    private String vulnerability;
    private String phishing_social_engineering;
    private String customized_to_target;

    public SurveyResponseEntity() {
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

    public String getInsider_threat() {
        return insider_threat;
    }

    public void setInsider_threat(String insider_threat) {
        this.insider_threat = insider_threat;
    }

    public String getStrategic_rivals() {
        return strategic_rivals;
    }

    public void setStrategic_rivals(String strategic_rivals) {
        this.strategic_rivals = strategic_rivals;
    }

    public String getActivist_hacktivist() {
        return activist_hacktivist;
    }

    public void setActivist_hacktivist(String activist_hacktivist) {
        this.activist_hacktivist = activist_hacktivist;
    }

    public String getCriminals() {
        return criminals;
    }

    public void setCriminals(String criminals) {
        this.criminals = criminals;
    }

    public String getNation_states() {
        return nation_states;
    }

    public void setNation_states(String nation_states) {
        this.nation_states = nation_states;
    }

    public String getWeb_facing_applications() {
        return web_facing_applications;
    }

    public void setWeb_facing_applications(String web_facing_applications) {
        this.web_facing_applications = web_facing_applications;
    }

    public String getInternet_exposed_devices() {
        return internet_exposed_devices;
    }

    public void setInternet_exposed_devices(String internet_exposed_devices) {
        this.internet_exposed_devices = internet_exposed_devices;
    }

    public String getEnd_points() {
        return end_points;
    }

    public void setEnd_points(String end_points) {
        this.end_points = end_points;
    }

    public String getMobile_devices() {
        return mobile_devices;
    }

    public void setMobile_devices(String mobile_devices) {
        this.mobile_devices = mobile_devices;
    }

    public String getPublic_infrastructure_or_cloud() {
        return public_infrastructure_or_cloud;
    }

    public void setPublic_infrastructure_or_cloud(String public_infrastructure_or_cloud) {
        this.public_infrastructure_or_cloud = public_infrastructure_or_cloud;
    }

    public String getCounterparties() {
        return counterparties;
    }

    public void setCounterparties(String counterparties) {
        this.counterparties = counterparties;
    }

    public String getAutonomous_network_connected_devices() {
        return autonomous_network_connected_devices;
    }

    public void setAutonomous_network_connected_devices(String autonomous_network_connected_devices) {
        this.autonomous_network_connected_devices = autonomous_network_connected_devices;
    }

    public String getVulnerability_to_known_threats() {
        return vulnerability_to_known_threats;
    }

    public void setVulnerability_to_known_threats(String vulnerability_to_known_threats) {
        this.vulnerability_to_known_threats = vulnerability_to_known_threats;
    }

    public String getVulnerability_to_unknown_threats() {
        return vulnerability_to_unknown_threats;
    }

    public void setVulnerability_to_unknown_threats(String vulnerability_to_unknown_threats) {
        this.vulnerability_to_unknown_threats = vulnerability_to_unknown_threats;
    }

    public String getData_theft() {
        return data_theft;
    }

    public void setData_theft(String data_theft) {
        this.data_theft = data_theft;
    }

    public String getData_modification() {
        return data_modification;
    }

    public void setData_modification(String data_modification) {
        this.data_modification = data_modification;
    }

    public String getBusiness_disruption() {
        return business_disruption;
    }

    public void setBusiness_disruption(String business_disruption) {
        this.business_disruption = business_disruption;
    }

    public String getFalse_claims_of_digital_identity() {
        return false_claims_of_digital_identity;
    }

    public void setFalse_claims_of_digital_identity(String false_claims_of_digital_identity) {
        this.false_claims_of_digital_identity = false_claims_of_digital_identity;
    }

    public String getMedia_public_perception() {
        return media_public_perception;
    }

    public void setMedia_public_perception(String media_public_perception) {
        this.media_public_perception = media_public_perception;
    }

    public String getPersonal_risk() {
        return personal_risk;
    }

    public void setPersonal_risk(String personal_risk) {
        this.personal_risk = personal_risk;
    }

    public String getBotnets() {
        return botnets;
    }

    public void setBotnets(String botnets) {
        this.botnets = botnets;
    }

    public String getMass_malware() {
        return mass_malware;
    }

    public void setMass_malware(String mass_malware) {
        this.mass_malware = mass_malware;
    }

    public String getVulnerability() {
        return vulnerability;
    }

    public void setVulnerability(String vulnerability) {
        this.vulnerability = vulnerability;
    }

    public String getPhishing_social_engineering() {
        return phishing_social_engineering;
    }

    public void setPhishing_social_engineering(String phishing_social_engineering) {
        this.phishing_social_engineering = phishing_social_engineering;
    }

    public String getCustomized_to_target() {
        return customized_to_target;
    }

    public void setCustomized_to_target(String customized_to_target) {
        this.customized_to_target = customized_to_target;
    }

    @Override
    public String toString() {
        return "SurveyResponseEntity{" +
                "id=" + id +
                ", date=" + date +
                ", insider_threat='" + insider_threat + '\'' +
                ", strategic_rivals='" + strategic_rivals + '\'' +
                ", activist_hacktivist='" + activist_hacktivist + '\'' +
                ", criminals='" + criminals + '\'' +
                ", nation_states='" + nation_states + '\'' +
                ", web_facing_applications='" + web_facing_applications + '\'' +
                ", internet_exposed_devices='" + internet_exposed_devices + '\'' +
                ", end_points='" + end_points + '\'' +
                ", mobile_devices='" + mobile_devices + '\'' +
                ", public_infrastructure_or_cloud='" + public_infrastructure_or_cloud + '\'' +
                ", counterparties='" + counterparties + '\'' +
                ", autonomous_network_connected_devices='" + autonomous_network_connected_devices + '\'' +
                ", vulnerability_to_known_threats='" + vulnerability_to_known_threats + '\'' +
                ", vulnerability_to_unknown_threats='" + vulnerability_to_unknown_threats + '\'' +
                ", data_theft='" + data_theft + '\'' +
                ", data_modification='" + data_modification + '\'' +
                ", business_disruption='" + business_disruption + '\'' +
                ", false_claims_of_digital_identity='" + false_claims_of_digital_identity + '\'' +
                ", media_public_perception='" + media_public_perception + '\'' +
                ", personal_risk='" + personal_risk + '\'' +
                ", botnets='" + botnets + '\'' +
                ", mass_malware='" + mass_malware + '\'' +
                ", vulnerability='" + vulnerability + '\'' +
                ", phishing_social_engineering='" + phishing_social_engineering + '\'' +
                ", customized_to_target='" + customized_to_target + '\'' +
                '}';
    }
}
