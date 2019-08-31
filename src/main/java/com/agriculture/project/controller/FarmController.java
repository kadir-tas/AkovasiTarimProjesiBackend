package com.agriculture.project.controller;

import com.agriculture.project.controller.request.RegisterFarmRequest;
import com.agriculture.project.controller.request.UpdateFarmRequest;
import com.agriculture.project.model.Message;
import com.agriculture.project.model.dto.FarmInfoDto;
import com.agriculture.project.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/farm")
public class FarmController {

    @Autowired
    FarmService farmService;

    @Secured("ROLE_ADMIN")
    @PostMapping("/remove")
    ResponseEntity<?>
    removeFarm(@RequestParam Long farmId ){
        if (farmService.removeFarm(farmId)) {
            return new ResponseEntity<>(new Message("Farm " + farmId + " removed successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Failed to remove farm " + farmId), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/register")
    ResponseEntity<?>
    createFarm( @RequestBody RegisterFarmRequest registerFarmRequest){
        if( farmService.registerFarm(registerFarmRequest) ){
            return new ResponseEntity<>(new Message("Farm " + registerFarmRequest.getFarmName() + " registered successfully"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Farm " + registerFarmRequest.getFarmName() + " failed to register"),HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/get")
    ResponseEntity<?>
    getFarm(@RequestParam Long farmId){
        FarmInfoDto farmInfoDto = farmService.getFarm(farmId);
        return new ResponseEntity<>(farmInfoDto, farmInfoDto != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/get/all")
    ResponseEntity<?>
    getAllFarm() {
        Set<FarmInfoDto> farmInfoDto = farmService.getAllFarm();
        return new ResponseEntity<>(farmInfoDto, farmInfoDto != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(path = "/update")
    ResponseEntity<?>
    updateFarm(@RequestBody UpdateFarmRequest updateFarmRequest){
        if (farmService.updateFarm(updateFarmRequest)) {
            return new ResponseEntity<>(new Message("Farm " + updateFarmRequest.getFarmId() + " updated successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Failed to update farm " + updateFarmRequest.getFarmId()), HttpStatus.BAD_REQUEST);
        }
    }
}
