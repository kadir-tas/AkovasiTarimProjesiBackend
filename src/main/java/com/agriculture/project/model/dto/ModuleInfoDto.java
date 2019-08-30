package com.agriculture.project.model.dto;

import com.agriculture.project.model.Module;

import java.util.Date;
import java.util.Set;

public class ModuleInfoDto {

    private String moduleId;
    private Date lastUpdatedDate;
    private String moduleState;
    private Set<ModuleValueDto> moduleValues;
    private FarmDto farm;

    public ModuleInfoDto(Module module){
        this.moduleId = module.getModuleId();
        this.lastUpdatedDate = module.getLastUpdatedDate();
        this.moduleState = module.getModuleState();
        this.moduleValues = module.getModuleValuesDto();
        this.farm = module.getFarmDto();
    }

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

    public Set<ModuleValueDto> getModuleValues() {
        return moduleValues;
    }

    public void setModuleValues(Set<ModuleValueDto> moduleValues) {
        this.moduleValues = moduleValues;
    }

    public FarmDto getFarm() {
        return farm;
    }

    public void setFarm(FarmDto farm) {
        this.farm = farm;
    }
}
