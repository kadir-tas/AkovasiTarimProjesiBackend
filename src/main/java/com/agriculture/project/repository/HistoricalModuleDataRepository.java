package com.agriculture.project.repository;

import com.agriculture.project.model.HistoricalModuleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricalModuleDataRepository extends JpaRepository<HistoricalModuleData, Long> {
}
