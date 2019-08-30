package com.agriculture.project.controller;

import com.agriculture.project.controller.request.RegisterFarmRequest;
import com.agriculture.project.controller.request.UpdateFarmRequest;
import com.agriculture.project.model.Message;
import com.agriculture.project.model.dto.FarmDto;
import com.agriculture.project.model.dto.FarmInfoDto;
import com.agriculture.project.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farm")
public class FarmController {

    @Autowired
    FarmService farmService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/remove")
    ResponseEntity<?>
    removeFarm(@RequestParam Long farmId ){
        return new ResponseEntity<>(farmService.removeFarm(farmId) ? HttpStatus.OK  : HttpStatus.NOT_FOUND);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/register")
    ResponseEntity<?>
    createFarm( @RequestBody RegisterFarmRequest registerFarmRequest){
        if( farmService.registerFarm(registerFarmRequest) ){
            return new ResponseEntity<>( new Message("Farm " + registerFarmRequest.getFarmName() + " registered succsessfully"),HttpStatus.OK);
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
    @PutMapping(path = "/update")
    ResponseEntity<?>
    updateFarm(@RequestBody UpdateFarmRequest updateFarmRequest){
        return new ResponseEntity<>(farmService.updateFarm(updateFarmRequest) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
