package com.agriculture.project.model.dto;

import com.agriculture.project.model.Module;
import com.agriculture.project.model.ModuleValue;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class ModuleValueDto implements Serializable {

    private String valueType;
    private double value;

    public ModuleValueDto(ModuleValue moduleValue){
        this.value = moduleValue.getValue();
        this.valueType = moduleValue.getModuleValuePrimaryKey().getValueType();
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
