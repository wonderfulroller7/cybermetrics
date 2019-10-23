package com.nyu.cybermetrics.dtos;

public class Defenses {

    private String vulnerability_to_known_threats;
    private String vulnerability_to_unknown_threats;

    public Defenses() {
    }

    public Defenses(String vulnerability_to_known_threats, String vulnerability_to_unknown_threats) {
        this.vulnerability_to_known_threats = vulnerability_to_known_threats;
        this.vulnerability_to_unknown_threats = vulnerability_to_unknown_threats;
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

    @Override
    public String toString() {
        return "Defenses{" +
                "vulnerability_to_known_threats='" + vulnerability_to_known_threats + '\'' +
                ", vulnerability_to_unknown_threats='" + vulnerability_to_unknown_threats + '\'' +
                '}';
    }
}
