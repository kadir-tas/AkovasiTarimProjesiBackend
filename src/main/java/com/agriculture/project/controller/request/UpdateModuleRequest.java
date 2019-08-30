package com.agriculture.project.controller.request;

import com.agriculture.project.model.Farm;

import java.util.Date;

public class UpdateModuleRequest {
    private String moduleId;
    private Date lastUpdatedDate;
    private String moduleState;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getModuleState() {
        return moduleState;
    }

    public void setModuleState(String moduleState) {
        this.moduleState = moduleState;
    }
}
