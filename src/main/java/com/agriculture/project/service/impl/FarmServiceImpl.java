package com.agriculture.project.service.impl;

import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Module;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FarmServiceImpl implements FarmService {

    @Autowired
    FarmRepository farmRepository;

    @Override
    public boolean createFarm(Farm farm) {
        if(farmRepository.existsById(farm.getFarmId())){
            return false;
        }else{
            /*TODO: Registration date is currnelly assumed to be the date that is been saved into database change maybe ????????*/
            farm.setFarmRegistrationDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
            farmRepository.save(farm);
            return true;
        }
    }

    @Override
    public boolean updateFarm(Farm farm) {
        Optional<Farm> optionalModule = farmRepository.findById(farm.getFarmId());
        if(optionalModule.isPresent()) {
            Farm f = optionalModule.get();

            /*So that only the values that has been provided will be updated*/
            if(!farm.getFarmName().equals(""))     f.setFarmName(farm.getFarmName());
            if(!farm.getFarmAddress().equals(""))  f.setFarmAddress(farm.getFarmAddress());
            if(farm.getFarmLocationLat() != 0)     f.setFarmLocationLat(farm.getFarmLocationLat()); /*Unless the farm is at "Null island" there should be no problem*/
            if(farm.getFarmLocationLon() != 0)     f.setFarmLocationLon(farm.getFarmLocationLon());
            if(farm.getFarmSize() != 0)            f.setFarmSize(farm.getFarmSize());

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
    public Farm getFarm(long farmId) {
        Optional<Farm> m = farmRepository.findById(farmId);
        if(m.isPresent()){
            return m.get();
        }else{
            return null;
        }
    }

    @Override
    public Set<Module> getFarmModules(long farmId) {
        Optional<Farm> farm = farmRepository.findById(farmId);
        if(farm.isPresent()){
            return farm.get().getModules();
        }
        return null;
    }
}
