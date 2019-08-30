package com.agriculture.project.service;

import com.agriculture.project.controller.request.FarmModuleRequest;
import com.agriculture.project.controller.request.RegisterModuleRequest;
import com.agriculture.project.controller.request.UpdateModuleRequest;
import com.agriculture.project.model.dto.ModuleDto;
import com.agriculture.project.model.dto.ModuleInfoDto;

import java.util.List;


public interface ModulesService {
    boolean           registerModule(RegisterModuleRequest registerModuleRequest);
    boolean           removeModule  (String moduleId);
    boolean           updateModule  (UpdateModuleRequest updateModuleRequest);

    boolean           assignModuleToFarm(FarmModuleRequest farmModuleRequest);
    boolean           revokeFarmFromModule(FarmModuleRequest farmModuleRequest);

    List<ModuleInfoDto> getAllModules ();
    ModuleInfoDto       getModule (String moduleId);

    boolean          updateModuleValues(String formatedData) throws Exception;
}
