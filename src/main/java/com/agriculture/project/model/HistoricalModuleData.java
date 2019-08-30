package com.agriculture.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class HistoricalModuleData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String moduleId;
    private String valueType;
    private float  value;
    private Date date;
    private long farmId;
    private String product;

}
