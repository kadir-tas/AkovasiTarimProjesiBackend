package com.agriculture.project.service;

import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Module;
import java.util.List;
import java.util.Set;

public interface FarmService {
    boolean      createFarm(Farm farm);
    boolean      updateFarm(Farm farm);
    boolean      removeFarm(long farmId);
    Farm         getFarm   (long farmId);
    Set<Module> getFarmModules(long farmId);
}
