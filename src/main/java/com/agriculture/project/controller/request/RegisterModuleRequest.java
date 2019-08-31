package com.agriculture.project.controller.request;

import com.agriculture.project.model.Farm;

public class RegisterModuleRequest {
    private String moduleId;
    private String moduleState;
    private Farm farm;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleState() {
        return moduleState;
    }

    public void setModuleState(String moduleState) {
        this.moduleState = moduleState;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
