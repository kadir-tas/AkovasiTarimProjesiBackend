package com.agriculture.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Module implements Serializable {

    @Id
    private String moduleId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate; /*when this module got updated*/

    @NotNull
    private String moduleState; /*working or not*/

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "module", cascade = CascadeType.ALL)
    private Set<ModuleValue> moduleValues = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "farmId")
    private Farm farm;

}
