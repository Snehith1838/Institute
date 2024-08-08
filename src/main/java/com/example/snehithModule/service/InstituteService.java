package com.example.snehithModule.service;

import com.example.snehithModule.entity.InstituteModule;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InstituteService {

    List<InstituteModule> getAllMembers();

    void saveMember(InstituteModule instituteModule);

    void deleteMember(Long id);

    void updateMember(InstituteModule instituteModule, Long id);
}
