package com.nyu.cybermetrics.dtos;

public class Weapons {

    private String botnets;
    private String mass_malware;
    private String vulnerability;
    private String phishing_social_engineering;
    private String customized_to_target;

    public Weapons() {
    }

    public Weapons(String botnets, String mass_malware, String vulnerability, String phishing_social_engineering, String customized_to_target) {
        this.botnets = botnets;
        this.mass_malware = mass_malware;
        this.vulnerability = vulnerability;
        this.phishing_social_engineering = phishing_social_engineering;
        this.customized_to_target = customized_to_target;
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
        return "Weapons{" +
                "botnets='" + botnets + '\'' +
                ", mass_malware='" + mass_malware + '\'' +
                ", vulnerability='" + vulnerability + '\'' +
                ", phishing_social_engineering='" + phishing_social_engineering + '\'' +
                ", customized_to_target='" + customized_to_target + '\'' +
                '}';
    }
}
