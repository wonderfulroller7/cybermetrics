package com.nyu.cybermetrics.dtos;

public class AttackTargets {

    private String web_facing_applications;
    private String internet_exposed_devices;
    private String end_points;
    private String mobile_devices;
    private String public_infrastructure_or_cloud;
    private String counterparties;
    private String autonomous_network_connected_devices;

    public AttackTargets() {
    }

    public AttackTargets(String web_facing_applications,
                         String internet_exposed_devices,
                         String end_points,
                         String mobile_devices,
                         String public_infrastructure_or_cloud,
                         String counterparties,
                         String autonomous_network_connected_devices) {
        this.web_facing_applications = web_facing_applications;
        this.internet_exposed_devices = internet_exposed_devices;
        this.end_points = end_points;
        this.mobile_devices = mobile_devices;
        this.public_infrastructure_or_cloud = public_infrastructure_or_cloud;
        this.counterparties = counterparties;
        this.autonomous_network_connected_devices = autonomous_network_connected_devices;
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

    @Override
    public String toString() {
        return "AttackTargets{" +
                "web_facing_applications='" + web_facing_applications + '\'' +
                ", internet_exposed_devices='" + internet_exposed_devices + '\'' +
                ", end_points='" + end_points + '\'' +
                ", mobile_devices='" + mobile_devices + '\'' +
                ", public_infrastructure_or_cloud='" + public_infrastructure_or_cloud + '\'' +
                ", counterparties='" + counterparties + '\'' +
                ", autonomous_network_connected_devices='" + autonomous_network_connected_devices + '\'' +
                '}';
    }
}
