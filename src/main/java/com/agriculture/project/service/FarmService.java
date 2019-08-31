package com.agriculture.project.service;

import com.agriculture.project.controller.request.RegisterFarmRequest;
import com.agriculture.project.controller.request.UpdateFarmRequest;
import com.agriculture.project.model.dto.FarmInfoDto;

import java.util.Set;

public interface FarmService {
    boolean      registerFarm(RegisterFarmRequest registerFarmRequest);
    boolean      updateFarm(UpdateFarmRequest updateFarmRequest);
    boolean      removeFarm(long farmId);
    FarmInfoDto  getFarm   (long farmId);

    Set<FarmInfoDto> getAllFarm();
}
