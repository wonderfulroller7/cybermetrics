package com.nyu.cybermetrics.dtos;

import java.util.ArrayList;

public class ChartDto {

    private ArrayList<Double> data;
    private String label;
    private String yAxisID;

    public ChartDto() {
        data = new ArrayList<Double>();
        yAxisID = "A";
    }

    public ArrayList<Double> getData() {
        return data;
    }

    public void setData(ArrayList<Double> data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getyAxisID() {
        return yAxisID;
    }

    public void setyAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
    }
}
