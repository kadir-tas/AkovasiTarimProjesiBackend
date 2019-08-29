package com.agriculture.project.controller;

import com.agriculture.project.controller.request.FarmsModulesRequest;
import com.agriculture.project.model.Module;
import com.agriculture.project.model.ModuleValue;
import com.agriculture.project.repository.ModuleValueRepository;
import com.agriculture.project.repository.ModuleRepository;
import com.agriculture.project.service.ModulesService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ModuleController {

    @Autowired
    ModulesService modulesService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/requestModuleValues")
    @ResponseBody List<ModuleValue>
    requestModuleValues(@RequestParam String moduleId ){
        return modulesService.getModuleValues(moduleId);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/removeModule")
    @ResponseBody HttpStatus
    removeModule(@RequestParam String moduleId ){
        return modulesService.removeModule(moduleId) ? HttpStatus.OK  : HttpStatus.NOT_FOUND;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/registerModule")
    @ResponseBody HttpStatus
    registerModule( @RequestBody Module module){
        if( modulesService.registerModule(module) ){
            return HttpStatus.OK;
        }else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/getModule")
    @ResponseBody Module
    getModule(@RequestParam String moduleId){
        return modulesService.getModule(moduleId);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(path = "/updateModule")
    @ResponseBody HttpStatus
    updateModule(@RequestBody Module module){
        return modulesService.modifyModule(module) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/assignModuleToFarm")
    @ResponseBody HttpStatus
    assignModuleToFarm( @RequestBody FarmsModulesRequest farmsModulesRequest){
        return modulesService.assignModuleToFarm(farmsModulesRequest.getModuleId() , farmsModulesRequest.getFarmId()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/unassignModuleToFarm")
    @ResponseBody HttpStatus
    unassignModuleToFarm( @RequestBody FarmsModulesRequest farmsModulesRequest){
        return modulesService.unassignModuleToFarm(farmsModulesRequest.getModuleId() , farmsModulesRequest.getFarmId()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
}
