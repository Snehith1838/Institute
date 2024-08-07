package com.example.snehithModule.service;

import com.example.snehithModule.entity.InstituteModule;
import com.example.snehithModule.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService{

    @Autowired
    private InstituteRepository instituteRepository;

    public List<InstituteModule> getAllMembers() {
        return instituteRepository.findAll();
    }

    public void saveMember(InstituteModule instituteModule) {
        List<InstituteModule> sameName = instituteRepository.findByName(instituteModule.getName());
        if(sameName.isEmpty()) {
            instituteRepository.save(instituteModule);
        }else {
            throw new RuntimeException("Name already Exist");
        }
    }

    public void deleteMember(Long id) {
        InstituteModule a = instituteRepository.findById(id).orElse(null);
        if(a != null) {
            instituteRepository.deleteById(id);
        }else {
            throw new RuntimeException("Resource Not Found");
        }
    }

    public void updateMember(InstituteModule instituteModule, Long id) {
        InstituteModule a = instituteRepository.findById(id).orElse(null);
        if(a != null){
            a.setName(instituteModule.getName());
            instituteRepository.save(a);
        }else {
            throw new RuntimeException("Resource Not Found");
        }
    }
}
