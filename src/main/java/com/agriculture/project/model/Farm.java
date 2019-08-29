package com.agriculture.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

    @JsonIgnore
    @ManyToMany(mappedBy = "farms")
    private Set<User> users = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "farm", cascade = CascadeType.ALL)
    private Set<Module> modules = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "farm", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private FarmDrawData farmDrawData;

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
