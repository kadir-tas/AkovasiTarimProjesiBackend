package com.agriculture.project.controller;

import com.agriculture.project.controller.request.FarmModuleRequest;
import com.agriculture.project.controller.request.RegisterModuleRequest;
import com.agriculture.project.model.Message;
import com.agriculture.project.model.dto.ModuleInfoDto;
import com.agriculture.project.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    ModulesService modulesService;

    @Secured("ROLE_ADMIN")
    @PostMapping("/remove")
    ResponseEntity<?>
    removeModule(@RequestParam String moduleId ){
        if(modulesService.removeModule(moduleId)){
            return new ResponseEntity<>(new Message("Module " + moduleId + " removed succsessfuly") , HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Message("Failed to remove module:" + moduleId) , HttpStatus.NOT_FOUND);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/register")
    ResponseEntity<?>
    registerModule(@RequestBody RegisterModuleRequest registerModuleRequest){
        if(modulesService.registerModule(registerModuleRequest)){
            return new ResponseEntity<>(new Message("Module " + registerModuleRequest.getModuleId() + " is registered") , HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to register module: " + registerModuleRequest.getModuleId()) , HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/get")
    ResponseEntity<?>
    getModule(@RequestParam String moduleId){
        ModuleInfoDto moduleInfoDto = modulesService.getModule(moduleId);
        return new ResponseEntity<>(moduleInfoDto, moduleInfoDto != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/get/all")
    ResponseEntity<?>
    getAllModule(){
        List<ModuleInfoDto> moduleInfoDto = modulesService.getAllModules();
        return new ResponseEntity<>(moduleInfoDto, moduleInfoDto != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    //NOTE: CODE BELLOW IS NO NEEDED RIGHT NOW BECAUSE ALL THE UPDATE STUFF WILL BE DONE THROUGH TCP
/*
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/update")
    ResponseEntity<?>
    updateModule(@RequestBody UpdateModuleRequest updateModuleRequest){
        if(modulesService.updateModule(updateModuleRequest)){
            return new ResponseEntity<>(new Message("Module " + updateModuleRequest.getModuleId() + " is updated") , HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to update module: " + updateModuleRequest.getModuleId()) , HttpStatus.BAD_REQUEST);
        }
    }
*/
    @Secured("ROLE_ADMIN")
    @PostMapping("/assign/farm")
    ResponseEntity<?>
    assignModuleToFarm( @RequestBody FarmModuleRequest farmModuleRequest){
        if(modulesService.assignModuleToFarm(farmModuleRequest)){
            return new ResponseEntity<>(new Message("Module " + farmModuleRequest.getModuleId() + " is assign to farm " + farmModuleRequest.getFarmId()) , HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to assign module: " + farmModuleRequest.getModuleId() + " to farm " + farmModuleRequest.getFarmId()), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/revoke/farm")
    ResponseEntity<?>
    unassignModuleToFarm( @RequestBody FarmModuleRequest farmModuleRequest){
        if(modulesService.revokeFarmFromModule(farmModuleRequest)){
            return new ResponseEntity<>(new Message("Module " + farmModuleRequest.getModuleId() + " is revoked from farm " + farmModuleRequest.getFarmId()) , HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to revoke module: " + farmModuleRequest.getModuleId() + " from farm " + farmModuleRequest.getFarmId()), HttpStatus.BAD_REQUEST);
        }
    }
}
