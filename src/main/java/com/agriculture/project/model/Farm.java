package com.agriculture.project.model;

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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Farm implements Serializable {

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
    private List<User> users;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "farm", cascade = CascadeType.ALL)
    private Set<Module> modules = new HashSet<>();

    @OneToOne(mappedBy = "farm", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private FarmDrawData farmDrawData;

}
