package com.agriculture.project.service.impl;

import com.agriculture.project.controller.request.RegisterFarmRequest;
import com.agriculture.project.controller.request.UpdateFarmRequest;
import com.agriculture.project.model.Farm;
import com.agriculture.project.model.dto.FarmInfoDto;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class FarmServiceImpl implements FarmService {

    @Autowired
    FarmRepository farmRepository;

    @Override
    public boolean registerFarm(RegisterFarmRequest registerFarmRequest) {
        Farm f = new Farm(registerFarmRequest);
        f.setFarmRegistrationDate(new Date());
        farmRepository.save(new Farm(registerFarmRequest));
        return true;
    }

    @Override
    public boolean updateFarm(UpdateFarmRequest updateFarmRequest) {
        Optional<Farm> optionalModule = farmRepository.findById(updateFarmRequest.getFarmId());
        if(optionalModule.isPresent()) {
            Farm f = optionalModule.get();

            /*So that only the values that has been provided will be updated*/
            if(!updateFarmRequest.getFarmName().equals(""))     f.setFarmName(updateFarmRequest.getFarmName());
            if(!updateFarmRequest.getFarmAddress().equals(""))  f.setFarmAddress(updateFarmRequest.getFarmAddress());
            if(updateFarmRequest.getFarmLocationLat() != 0)     f.setFarmLocationLat(updateFarmRequest.getFarmLocationLat()); /*Unless the farm is at "Null island" there should be no problem*/
            if(updateFarmRequest.getFarmLocationLon() != 0)     f.setFarmLocationLon(updateFarmRequest.getFarmLocationLon());
            if(updateFarmRequest.getFarmSize() != 0)            f.setFarmSize(updateFarmRequest.getFarmSize());

            farmRepository.save(f);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean removeFarm(long farmId) {
        if(farmRepository.existsById(farmId)){
            farmRepository.deleteById(farmId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public FarmInfoDto getFarm(long farmId) {
        Optional<Farm> m = farmRepository.findById(farmId);
        if(m.isPresent()){
            return new FarmInfoDto(m.get());
        }else{
            return null;
        }
    }
}
