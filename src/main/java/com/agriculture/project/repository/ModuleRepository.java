package com.agriculture.project.repository;
import com.agriculture.project.model.Module;
import com.agriculture.project.model.ModuleValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module,String> {
}
