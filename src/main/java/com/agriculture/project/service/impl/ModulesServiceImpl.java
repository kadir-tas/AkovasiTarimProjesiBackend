package com.agriculture.project.service.impl;

import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Module;
import com.agriculture.project.model.ModuleValue;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.repository.ModuleRepository;
import com.agriculture.project.repository.ModuleValueRepository;
import com.agriculture.project.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean registerModule(Module module) {
        Optional<Module> optionalModule = moduleRepository.findById(module.getModuleId());
        if(optionalModule.isPresent()) {
            return  false;
        }else{
            moduleRepository.save(module);
            return true;
        }
    }

    @Override
    public boolean removeModule(String moduleId) {
        if(moduleRepository.existsById(moduleId)){
            moduleRepository.deleteById(moduleId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean modifyModule(Module module) {
        System.out.println(module);
        System.out.println(moduleRepository);

        Optional<Module> optionalModule = moduleRepository.findById(module.getModuleId());
        if(optionalModule.isPresent()) {
            Module m = optionalModule.get();

            /*So that only the values that has been provided will be updated*/
            if(module.getLastUpdatedDate() != null )    m.setLastUpdatedDate(module.getLastUpdatedDate());
            if(!module.getModuleState().equals(""))     m.setModuleState(module.getModuleState()); /*TODO: Make sure state is a valid state*/

            moduleRepository.save(m);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean assignModuleToFarm(String moduleId, Long farmId) {
        Optional<Module> moduleOp = moduleRepository.findById(moduleId);
        Optional<Farm> farmOp = farmRepository.findById(farmId);
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
    public boolean unassignModuleToFarm(String moduleId, Long farmId) {
        Optional<Module> moduleOp = moduleRepository.findById(moduleId);
        Optional<Farm> farmOp = farmRepository.findById(farmId);
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
    public boolean updateModuleValues(String data) {
        return true;
    }

    @Override
    public List<ModuleValue> getModuleValues(String moduleId) {
        return moduleValueRepository.findByModuleValuePrimaryKeyModuleId(moduleId);
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @Override
    public Module getModule(String moduleId) {
        Optional<Module> m = moduleRepository.findById(moduleId);
        if(m.isPresent()){
            return m.get();
        }else{
            return null;
        }
    }
}
