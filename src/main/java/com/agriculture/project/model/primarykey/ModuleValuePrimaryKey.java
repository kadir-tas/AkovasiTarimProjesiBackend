package com.agriculture.project.model.primarykey;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data /*If there is no get func. Json wont be able to show class data*/
@Embeddable
public class ModuleValuePrimaryKey implements Serializable {

    @NotNull
    private String moduleId;

    @NotNull
    private String valueType;

    public ModuleValuePrimaryKey() {

    }

    public ModuleValuePrimaryKey(String moduleId, String valueType) {
        this.moduleId = moduleId;
        this.valueType = valueType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ModuleValuePrimaryKey a = (ModuleValuePrimaryKey) obj;
        return this.moduleId.equals(a.moduleId) || !valueType.equals(a.valueType);

    }

    @Override
    public int hashCode() {
        int result = moduleId.hashCode();
        result = 31 * result + valueType.hashCode();
        return result;
    }
}
