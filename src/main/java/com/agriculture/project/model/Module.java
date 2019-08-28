package com.agriculture.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Module implements Serializable {

    @Id
    private String moduleId;

    private long farmId; /*which farm does this module currenlty belong to*/

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate; /*when this module got updated*/

    @NotNull
    private String moduleState; /*working or not*/

}
