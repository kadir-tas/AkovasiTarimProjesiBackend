package com.agriculture.project.repository;

import com.agriculture.project.model.ModuleValue;
import com.agriculture.project.model.primarykey.ModuleValuePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleValueRepository extends JpaRepository<ModuleValue, ModuleValuePrimaryKey> {

    public List<ModuleValue> findByModuleValuePrimaryKeyModuleId(String moduleId);
}
