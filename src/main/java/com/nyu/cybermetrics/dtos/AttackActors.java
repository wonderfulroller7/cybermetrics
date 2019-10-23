package com.nyu.cybermetrics.dtos;

public class AttackActors {

    private String insider_threat;
    private String strategic_rivals;
    private String activist_hacktivist;
    private String criminals;
    private String nation_states;

    public AttackActors() {
    }

    public AttackActors(String insider_threat, String strategic_rivals, String activist_hacktivist, String criminals, String nation_states) {
        this.insider_threat = insider_threat;
        this.strategic_rivals = strategic_rivals;
        this.activist_hacktivist = activist_hacktivist;
        this.criminals = criminals;
        this.nation_states = nation_states;
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

    @Override
    public String toString() {
        return "AttackActors{" +
                "insider_threat='" + insider_threat + '\'' +
                ", strategic_rivals='" + strategic_rivals + '\'' +
                ", activist_hacktivist='" + activist_hacktivist + '\'' +
                ", criminals='" + criminals + '\'' +
                ", nation_states='" + nation_states + '\'' +
                '}';
    }
}
