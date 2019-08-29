package com.agriculture.project.controller;

import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Module;
import com.agriculture.project.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class FarmController {

    @Autowired
    FarmService farmService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/removeFarm")
    @ResponseBody HttpStatus
    removeFarm(@RequestParam Long farmId ){
        return farmService.removeFarm(farmId) ? HttpStatus.OK  : HttpStatus.NOT_FOUND;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/createFarm")
    @ResponseBody HttpStatus
    createFarm( @RequestBody Farm farm){
        if( farmService.createFarm(farm) ){
            return HttpStatus.OK;
        }else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/getFarm")
    @ResponseBody Farm
    getFarm(@RequestParam Long farmId){
        return farmService.getFarm(farmId);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/getFarmModules")
    @ResponseBody Set<Module>
    getFarmModules(@RequestParam Long farmId){
        return farmService.getFarmModules(farmId);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(path = "/updateFarm")
    @ResponseBody HttpStatus
    updateFarm(@RequestBody Farm farm){
        return farmService.updateFarm(farm) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
