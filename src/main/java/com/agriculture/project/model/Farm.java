package com.agriculture.project.model;

import com.agriculture.project.controller.request.RegisterFarmRequest;
import com.agriculture.project.model.dto.ModuleDto;
import com.agriculture.project.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Farm implements Serializable {
    /*Do not use @Data here because of the lombok recursion*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmId;

    @Column
    @NotEmpty
    private String farmName;

    @Column
    @NotEmpty
    private String farmAddress;

    @Column
    private float farmLocationLat;

    @Column
    private float farmLocationLon;

    @Column
    @Temporal(TemporalType.DATE)
    private Date farmRegistrationDate;

    @Column
    private double farmSize;

    @ManyToMany(mappedBy = "farms")
    private Set<User> users = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "farm", cascade = CascadeType.ALL)
    private Set<Module> modules = new HashSet<>();

    @OneToOne(mappedBy = "farm", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private FarmDrawData farmDrawData;


    public Farm(RegisterFarmRequest registerFarmRequest){
        this.farmName = registerFarmRequest.getFarmName();
        this.farmAddress = registerFarmRequest.getFarmAddress();
        this.farmLocationLat = registerFarmRequest.getFarmLocationLat();
        this.farmLocationLon = registerFarmRequest.getFarmLocationLon();
        this.farmSize = registerFarmRequest.getFarmSize();
    }

    public Set<UserDto> getUsersDto(){
        Set<UserDto> userDtos = new HashSet<>();
        for(User u : users)
            userDtos.add(new UserDto(u));
        return userDtos;
    }

    public Set<ModuleDto> getModulesDto(){
        Set<ModuleDto> moduleDtos = new HashSet<>();
        for(Module m : modules)
            moduleDtos.add(new ModuleDto(m));
        return moduleDtos;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public FarmDrawData getFarmDrawData() {
        return farmDrawData;
    }

    public void setFarmDrawData(FarmDrawData farmDrawData) {
        this.farmDrawData = farmDrawData;
    }
}
