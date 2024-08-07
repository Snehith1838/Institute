package com.example.snehithModule.repository;

import com.example.snehithModule.entity.InstituteModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstituteRepository extends JpaRepository<InstituteModule, Long> {
    List<InstituteModule> findByName(String name);
}
