package com.agriculture.project.service.impl;

import com.agriculture.project.controller.request.FarmModuleRequest;
import com.agriculture.project.controller.request.RegisterModuleRequest;
import com.agriculture.project.controller.request.UpdateModuleRequest;
import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Module;
import com.agriculture.project.model.dto.ModuleInfoDto;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.repository.ModuleRepository;
import com.agriculture.project.repository.ModuleValueRepository;
import com.agriculture.project.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModulesServiceImpl implements ModulesService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    ModuleValueRepository moduleValueRepository;

    @Autowired
    FarmRepository farmRepository;

    @Override
    public boolean registerModule(RegisterModuleRequest registerModuleRequest) {
        Optional<Module> optionalModule = moduleRepository.findById(registerModuleRequest.getModuleId());
        if(optionalModule.isPresent()) {
            return  false;
        }else{
            moduleRepository.save(new Module(registerModuleRequest));
            return true;
        }
    }

    @Override
    public boolean removeModule(String moduleId) {
        if (moduleRepository.existsById(moduleId)) {
            moduleRepository.deleteById(moduleId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateModule(UpdateModuleRequest updateModuleRequest) {

        Optional<Module> optionalModule = moduleRepository.findById(updateModuleRequest.getModuleId());
        if(optionalModule.isPresent()) {
            Module m = optionalModule.get();

            /*So that only the values that has been provided will be updated*/
            if(updateModuleRequest.getLastUpdatedDate() != null )    m.setLastUpdatedDate(updateModuleRequest.getLastUpdatedDate());
            if(!updateModuleRequest.getModuleState().equals(""))     m.setModuleState(updateModuleRequest.getModuleState()); /*TODO: Make sure state is a valid state*/
            moduleRepository.save(m);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean assignModuleToFarm(FarmModuleRequest farmModuleRequest) {
        Optional<Module> moduleOp = moduleRepository.findById(farmModuleRequest.getModuleId());
        Optional<Farm> farmOp = farmRepository.findById(farmModuleRequest.getFarmId());
        if(moduleOp.isPresent() && farmOp.isPresent()){
            Module m = moduleOp.get();
            Farm f = farmOp.get();
            if(m.getFarm() == null){
                m.setFarm(farmOp.get());
                f.getModules().add(m);
                farmRepository.save(f);
                moduleRepository.save(m);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean revokeFarmFromModule(FarmModuleRequest farmModuleRequest) {
        Optional<Module> moduleOp = moduleRepository.findById(farmModuleRequest.getModuleId());
        Optional<Farm> farmOp = farmRepository.findById(farmModuleRequest.getFarmId());
        if(moduleOp.isPresent() && farmOp.isPresent()){
            Module m = moduleOp.get();
            Farm f = farmOp.get();
            if(m.getFarm() != null && m.getFarm().equals(f)){
                m.setFarm(null);
                f.getModules().remove(m);
                farmRepository.save(f);
                moduleRepository.save(m);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ModuleInfoDto> getAllModules() {
        List<ModuleInfoDto> moduleDtos = new ArrayList<>();
        List<Module> modules = moduleRepository.findAll();
        for(Module m : modules){
           moduleDtos.add(new ModuleInfoDto(m));
        }
        return moduleDtos;
    }

    @Override
    public ModuleInfoDto getModule(String moduleId) {
        Optional<Module> m = moduleRepository.findById(moduleId);
        if(m.isPresent()){
            return new ModuleInfoDto(m.get());
        }else{
            return null;
        }
    }

    @Override
    public boolean updateModuleValues(String formatedData) {
        System.out.println(formatedData);
        return true;
    }
}
