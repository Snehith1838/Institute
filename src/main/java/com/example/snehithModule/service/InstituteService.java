package com.example.snehithModule.service;

import com.example.snehithModule.entity.InstituteModule;
import com.example.snehithModule.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    public List<InstituteModule> getAllMembers() {
        return instituteRepository.findAll();
    }

    public void saveMember(InstituteModule instituteModule) {
        instituteRepository.save(instituteModule);
    }

    public void deleteMember(Long id) {
        instituteRepository.deleteById(id);
    }

    public void updateMember(InstituteModule instituteModule, Long id) {
        InstituteModule a = instituteRepository.findById(id).orElse(null);
        if(a != null){
            a.setName(instituteModule.getName());
            instituteRepository.save(a);
        }
    }
}
