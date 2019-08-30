package com.agriculture.project.service;

import com.agriculture.project.model.Module;
import com.agriculture.project.model.ModuleValue;

import java.util.List;

public interface ModulesService {

    boolean           registerModule(Module module);
    boolean           removeModule  (String moduleId);
    boolean           modifyModule  (Module module);
    boolean           assignModuleToFarm(String moduleId, Long farmId);
    boolean           unassignModuleToFarm(String moduleId, Long farmId);

    boolean updateModuleValues(String data);
    List<ModuleValue> getModuleValues (String moduleId);
    List<Module>      getAllModules ();
    Module            getModule (String moduleId);
    /* Module value is expected to be received by TCP socket so no method to update module data*/
}
