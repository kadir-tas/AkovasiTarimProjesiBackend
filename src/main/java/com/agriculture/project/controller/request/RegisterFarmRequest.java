package com.agriculture.project.controller.request;

import java.util.Date;

public class RegisterFarmRequest {

    private String farmName;
    private String farmAddress;
    private float farmLocationLat;
    private float farmLocationLon;
    private double farmSize;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getFarmAddress() {
        return farmAddress;
    }

    public void setFarmAddress(String farmAddress) {
        this.farmAddress = farmAddress;
    }

    public float getFarmLocationLat() {
        return farmLocationLat;
    }

    public void setFarmLocationLat(float farmLocationLat) {
        this.farmLocationLat = farmLocationLat;
    }

    public float getFarmLocationLon() {
        return farmLocationLon;
    }

    public void setFarmLocationLon(float farmLocationLon) {
        this.farmLocationLon = farmLocationLon;
    }

    public double getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(double farmSize) {
        this.farmSize = farmSize;
    }
}
