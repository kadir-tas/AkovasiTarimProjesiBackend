package com.agriculture.project.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmModuleRequest {
    private String moduleId;
    private Long farmId;
}
