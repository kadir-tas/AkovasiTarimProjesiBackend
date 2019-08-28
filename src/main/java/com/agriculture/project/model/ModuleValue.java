package com.agriculture.project.model;

import com.agriculture.project.model.primarykey.ModuleValuePrimaryKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class ModuleValue implements Serializable {

    @EmbeddedId
    private ModuleValuePrimaryKey moduleValuePrimaryKey;

    @NotNull
    private double value;

    public ModuleValue() {

    }

    public ModuleValue(String moduleId, String value_type, double value) {
        moduleValuePrimaryKey = new ModuleValuePrimaryKey(moduleId, value_type);
        this.value = value;
    }
}
