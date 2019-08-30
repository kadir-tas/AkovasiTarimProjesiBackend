package com.agriculture.project.model.dto;

import com.agriculture.project.model.Farm;
import com.agriculture.project.model.User;

import java.util.Date;
import java.util.Set;

public class FarmInfoDto {

    private Long farmId;
    private String farmName;
    private String farmAddress;
    private float farmLocationLat;
    private float farmLocationLon;
    private Date farmRegistrationDate;
    private double farmSize;
    private Set<UserDto> users;
    private Set<ModuleDto> modules;

    public FarmInfoDto(Farm farm){
        this.farmId = farm.getFarmId();
        this.farmName = farm.getFarmName();
        this.farmAddress = farm.getFarmAddress();
        this.farmLocationLat = farm.getFarmLocationLat();
        this.farmLocationLon = farm.getFarmLocationLon();
        this.farmRegistrationDate = farm.getFarmRegistrationDate();
        this.farmSize = farm.getFarmSize();
        this.users = farm.getUsersDto();
        this.modules = farm.getModulesDto();
    }


    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

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

    public Date getFarmRegistrationDate() {
        return farmRegistrationDate;
    }

    public void setFarmRegistrationDate(Date farmRegistrationDate) {
        this.farmRegistrationDate = farmRegistrationDate;
    }

    public double getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(double farmSize) {
        this.farmSize = farmSize;
    }

    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }

    public Set<ModuleDto> getModules() {
        return modules;
    }

    public void setModules(Set<ModuleDto> modules) {
        this.modules = modules;
    }
}
