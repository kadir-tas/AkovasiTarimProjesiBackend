package com.agriculture.project.model.dto;

import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Module;
import com.agriculture.project.model.ModuleValue;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto implements Serializable {

    private String moduleId;
    private Date lastUpdatedDate;
    private String moduleState;

    public ModuleDto(Module module){
        this.moduleId = module.getModuleId();
        this.lastUpdatedDate = module.getLastUpdatedDate();
        this.moduleState = module.getModuleState();
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
}
