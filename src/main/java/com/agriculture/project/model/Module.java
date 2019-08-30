package com.agriculture.project.model;

import com.agriculture.project.controller.request.RegisterModuleRequest;
import com.agriculture.project.model.dto.FarmDto;
import com.agriculture.project.model.dto.ModuleValueDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "module", cascade = CascadeType.ALL)
    private Set<ModuleValue> moduleValues = new HashSet<>();

    /*NOTE: Uncomment bellow if you want only farm id to be returned*/
    //@JsonIgnoreProperties(value = {"farmName" ,"farmAddress","farmLocationLat","farmLocationLon","farmRegistrationDate","farmSize"})
    @ManyToOne
    @JoinColumn(name = "farmId")
    private Farm farm;

    public Module(RegisterModuleRequest registerModuleRequest){
        this.moduleId = registerModuleRequest.getModuleId();
        this.lastUpdatedDate = registerModuleRequest.getLastUpdatedDate();
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

    @ManyToMany(mappedBy = "modules")
    private List<Product> products;

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
