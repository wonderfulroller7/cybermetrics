package com.nyu.cybermetrics.entities;

import com.nyu.cybermetrics.repositories.SurveyIndexRepository;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "survey_index_monthly")
public class SurveyResponseIndexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    private double field_queried;

    @Transient
    private Date date_of_field;

    private Timestamp date;
    private double insider_threat;
    private double strategic_rivals;
    private double activist_hacktivist;
    private double criminals;
    private double nation_states;
    private double web_facing_applications;
    private double internet_exposed_devices;
    private double end_points;
    private double mobile_devices;
    private double public_infrastructure_or_cloud;
    private double counterparties;
    private double autonomous_network_connected_devices;
    private double vulnerability_to_known_threats;
    private double vulnerability_to_unknown_threats;
    private double data_theft;
    private double data_modification;
    private double business_disruption;
    private double false_claims_of_digital_identity;
    private double media_public_perception;
    private double personal_risk;
    private double botnets;
    private double mass_malware;
    private double vulnerability;
    private double phishing_social_engineering;
    private double customized_to_target;

    public SurveyResponseIndexEntity() {
    }

    public SurveyResponseIndexEntity(double field_queried) {
        this.field_queried = field_queried;
    }

    public SurveyResponseIndexEntity(double field_queried, Date date) {
        this.date_of_field = date;
        this.field_queried = field_queried;
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

    public double getInsider_threat() {
        return insider_threat;
    }

    public void setInsider_threat(double insider_threat) {
        this.insider_threat = insider_threat;
    }

    public double getStrategic_rivals() {
        return strategic_rivals;
    }

    public void setStrategic_rivals(double strategic_rivals) {
        this.strategic_rivals = strategic_rivals;
    }

    public double getActivist_hacktivist() {
        return activist_hacktivist;
    }

    public void setActivist_hacktivist(double activist_hacktivist) {
        this.activist_hacktivist = activist_hacktivist;
    }

    public double getCriminals() {
        return criminals;
    }

    public void setCriminals(double criminals) {
        this.criminals = criminals;
    }

    public double getNation_states() {
        return nation_states;
    }

    public void setNation_states(double nation_states) {
        this.nation_states = nation_states;
    }

    public double getWeb_facing_applications() {
        return web_facing_applications;
    }

    public void setWeb_facing_applications(double web_facing_applications) {
        this.web_facing_applications = web_facing_applications;
    }

    public double getInternet_exposed_devices() {
        return internet_exposed_devices;
    }

    public void setInternet_exposed_devices(double internet_exposed_devices) {
        this.internet_exposed_devices = internet_exposed_devices;
    }

    public double getEnd_points() {
        return end_points;
    }

    public void setEnd_points(double end_points) {
        this.end_points = end_points;
    }

    public double getMobile_devices() {
        return mobile_devices;
    }

    public void setMobile_devices(double mobile_devices) {
        this.mobile_devices = mobile_devices;
    }

    public double getPublic_infrastructure_or_cloud() {
        return public_infrastructure_or_cloud;
    }

    public void setPublic_infrastructure_or_cloud(double public_infrastructure_or_cloud) {
        this.public_infrastructure_or_cloud = public_infrastructure_or_cloud;
    }

    public double getCounterparties() {
        return counterparties;
    }

    public void setCounterparties(double counterparties) {
        this.counterparties = counterparties;
    }

    public double getAutonomous_network_connected_devices() {
        return autonomous_network_connected_devices;
    }

    public void setAutonomous_network_connected_devices(double autonomous_network_connected_devices) {
        this.autonomous_network_connected_devices = autonomous_network_connected_devices;
    }

    public double getVulnerability_to_known_threats() {
        return vulnerability_to_known_threats;
    }

    public void setVulnerability_to_known_threats(double vulnerability_to_known_threats) {
        this.vulnerability_to_known_threats = vulnerability_to_known_threats;
    }

    public double getVulnerability_to_unknown_threats() {
        return vulnerability_to_unknown_threats;
    }

    public void setVulnerability_to_unknown_threats(double vulnerability_to_unknown_threats) {
        this.vulnerability_to_unknown_threats = vulnerability_to_unknown_threats;
    }

    public double getData_theft() {
        return data_theft;
    }

    public void setData_theft(double data_theft) {
        this.data_theft = data_theft;
    }

    public double getData_modification() {
        return data_modification;
    }

    public void setData_modification(double data_modification) {
        this.data_modification = data_modification;
    }

    public double getBusiness_disruption() {
        return business_disruption;
    }

    public void setBusiness_disruption(double business_disruption) {
        this.business_disruption = business_disruption;
    }

    public double getFalse_claims_of_digital_identity() {
        return false_claims_of_digital_identity;
    }

    public void setFalse_claims_of_digital_identity(double false_claims_of_digital_identity) {
        this.false_claims_of_digital_identity = false_claims_of_digital_identity;
    }

    public double getMedia_public_perception() {
        return media_public_perception;
    }

    public void setMedia_public_perception(double media_public_perception) {
        this.media_public_perception = media_public_perception;
    }

    public double getPersonal_risk() {
        return personal_risk;
    }

    public void setPersonal_risk(double personal_risk) {
        this.personal_risk = personal_risk;
    }

    public double getBotnets() {
        return botnets;
    }

    public void setBotnets(double botnets) {
        this.botnets = botnets;
    }

    public double getMass_malware() {
        return mass_malware;
    }

    public void setMass_malware(double mass_malware) {
        this.mass_malware = mass_malware;
    }

    public double getVulnerability() {
        return vulnerability;
    }

    public void setVulnerability(double vulnerability) {
        this.vulnerability = vulnerability;
    }

    public double getPhishing_social_engineering() {
        return phishing_social_engineering;
    }

    public void setPhishing_social_engineering(double phishing_social_engineering) {
        this.phishing_social_engineering = phishing_social_engineering;
    }

    public double getCustomized_to_target() {
        return customized_to_target;
    }

    public void setCustomized_to_target(double customized_to_target) {
        this.customized_to_target = customized_to_target;
    }

    public double getField() {
        return field_queried;
    }

    public void setField(double field) {
        this.field_queried = field;
    }

    public Date getDate_of_field() {
        return date_of_field;
    }

    public void setDate_of_field(Date date_of_field) {
        this.date_of_field = date_of_field;
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
                '}';
    }
}
