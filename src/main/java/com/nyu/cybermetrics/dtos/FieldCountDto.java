package com.nyu.cybermetrics.dtos;

public class FieldCountDto {

    private String vector;
    private String type;
    private String map;
    private int risen;
    private int same;
    private int risen_fast;
    private int fallen;
    private int fallen_fast;

    public FieldCountDto() {
    }

    public String getVector() {
        return vector;
    }

    public void setVector(String vector) {
        this.vector = vector;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getRisen() {
        return risen;
    }

    public void setRisen(int risen) {
        this.risen = risen;
    }

    public int getSame() {
        return same;
    }

    public void setSame(int aStatic) {
        same = aStatic;
    }

    public int getRisen_fast() {
        return risen_fast;
    }

    public void setRisen_fast(int risen_fast) {
        this.risen_fast = risen_fast;
    }

    public int getFallen() {
        return fallen;
    }

    public void setFallen(int fallen) {
        this.fallen = fallen;
    }

    public int getFallen_fast() {
        return fallen_fast;
    }

    public void setFallen_fast(int fallen_fast) {
        this.fallen_fast = fallen_fast;
    }

    @Override
    public String toString() {
        return "FieldCountDto{" +
                "vector='" + vector + '\'' +
                ", type='" + type + '\'' +
                ", risen=" + risen +
                ", same=" + same +
                ", risen_fast=" + risen_fast +
                ", fallen=" + fallen +
                ", fallen_fast=" + fallen_fast +
                '}';
    }
}
