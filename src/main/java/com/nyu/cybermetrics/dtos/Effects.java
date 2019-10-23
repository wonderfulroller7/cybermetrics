package com.nyu.cybermetrics.dtos;

public class Effects {

    private String data_theft;
    private String data_modification;
    private String business_disruption;

    public Effects() {
    }

    public Effects(String data_theft, String data_modification, String business_disruption) {
        this.data_theft = data_theft;
        this.data_modification = data_modification;
        this.business_disruption = business_disruption;
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

    @Override
    public String toString() {
        return "Effects{" +
                "data_theft='" + data_theft + '\'' +
                ", data_modification='" + data_modification + '\'' +
                ", business_disruption='" + business_disruption + '\'' +
                '}';
    }
}
