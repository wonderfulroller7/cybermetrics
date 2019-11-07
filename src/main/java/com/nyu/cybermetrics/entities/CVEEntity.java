package com.nyu.cybermetrics.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "cve_data")
public class CVEEntity {

    @Id
    private String cveid;
    private double v2_exploitability_score;
    private double v2_impact_score;
    private double v3_exploitability_score;
    private double v3_impact_score;
    private Timestamp published_date;

    public CVEEntity() {
    }

    public String getCveid() {
        return cveid;
    }

    public void setCveid(String cveid) {
        this.cveid = cveid;
    }

    public double getV2_exploitability_score() {
        return v2_exploitability_score;
    }

    public void setV2_exploitability_score(double v2_exploitability_score) {
        this.v2_exploitability_score = v2_exploitability_score;
    }

    public double getV2_impact_score() {
        return v2_impact_score;
    }

    public void setV2_impact_score(double v2_impact_score) {
        this.v2_impact_score = v2_impact_score;
    }

    public double getV3_exploitability_score() {
        return v3_exploitability_score;
    }

    public void setV3_exploitability_score(double v3_exploitability_score) {
        this.v3_exploitability_score = v3_exploitability_score;
    }

    public double getV3_impact_score() {
        return v3_impact_score;
    }

    public void setV3_impact_score(double v3_impact_score) {
        this.v3_impact_score = v3_impact_score;
    }

    public Timestamp getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Timestamp published_date) {
        this.published_date = published_date;
    }

    @Override
    public String toString() {
        return "CVEEntity{" +
                "cveid='" + cveid + '\'' +
                ", v2_exploitability_score=" + v2_exploitability_score +
                ", v2_impact_score=" + v2_impact_score +
                ", v3_exploitability_score=" + v3_exploitability_score +
                ", v3_impact_score=" + v3_impact_score +
                ", published_date=" + published_date +
                '}';
    }
}
