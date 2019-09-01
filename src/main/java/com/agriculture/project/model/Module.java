package com.agriculture.project.model;

import com.agriculture.project.controller.request.RegisterModuleRequest;
import com.agriculture.project.model.dto.FarmDto;
import com.agriculture.project.model.dto.ModuleValueDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Module implements Serializable {
    /*Do not use @Data here because of the lombok recursion*/
    @Id
    private String moduleId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate; /*when this module got updated*/

    @NotNull
    private String moduleState; /*working or not*/

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModuleValue> moduleValues = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "farmId")
    private Farm farm;

    @ManyToMany(mappedBy = "modules")
    private List<Product> products = new ArrayList<>();

    public Module(RegisterModuleRequest registerModuleRequest){
        this.moduleId = registerModuleRequest.getModuleId();
        this.lastUpdatedDate = new Date();
        this.moduleState = registerModuleRequest.getModuleState();
        this.farm = registerModuleRequest.getFarm();
    }

    public FarmDto getFarmDto(){
        return new FarmDto(farm);
    }

    public Set<ModuleValueDto> getModuleValuesDto(){
        Set<ModuleValueDto> moduleValueDtos = new HashSet<>();
        for(ModuleValue mv : moduleValues){
            moduleValueDtos.add(new ModuleValueDto(mv));
        }
        return moduleValueDtos;
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

    public Set<ModuleValue> getModuleValues() {
        return moduleValues;
    }

    public void setModuleValues(Set<ModuleValue> moduleValues) {
        this.moduleValues = moduleValues;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
