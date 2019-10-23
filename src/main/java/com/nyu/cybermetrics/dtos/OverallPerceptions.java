package com.nyu.cybermetrics.dtos;

public class OverallPerceptions {

    private String false_claims_of_digital_identity;
    private String media_public_perception;
    private String personal_risk;

    public OverallPerceptions() {
    }

    public OverallPerceptions(String false_claims_of_digital_identity, String media_public_perception, String personal_risk) {
        this.false_claims_of_digital_identity = false_claims_of_digital_identity;
        this.media_public_perception = media_public_perception;
        this.personal_risk = personal_risk;
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

    @Override
    public String toString() {
        return "OverallPerceptions{" +
                "false_claims_of_digital_identity='" + false_claims_of_digital_identity + '\'' +
                ", media_public_perception='" + media_public_perception + '\'' +
                ", personal_risk='" + personal_risk + '\'' +
                '}';
    }
}
