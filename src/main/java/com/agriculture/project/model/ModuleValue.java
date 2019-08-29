package com.agriculture.project.model;

import com.agriculture.project.model.primarykey.ModuleValuePrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ModuleValue implements Serializable {

    @EmbeddedId
    private ModuleValuePrimaryKey moduleValuePrimaryKey;

    @ManyToOne
    @JoinColumn(name = "moduleId", referencedColumnName = "moduleId", nullable = false, insertable = false, updatable = false)
    private Module module = null;

    @NotNull
    private double value;

    public ModuleValue(String moduleId, String value_type, double value) {
        moduleValuePrimaryKey = new ModuleValuePrimaryKey(moduleId, value_type);
        this.value = value;
    }
}
