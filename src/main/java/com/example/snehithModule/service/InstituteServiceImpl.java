package com.example.snehithModule.service;

import com.example.snehithModule.entity.InstituteModule;
import com.example.snehithModule.exceptions.APIException;
import com.example.snehithModule.exceptions.ResourceNotFoundException;
import com.example.snehithModule.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService{

    @Autowired
    private InstituteRepository instituteRepository;

    @Override
    public List<InstituteModule> getAllMembers() {
        List<InstituteModule> membersData = instituteRepository.findAll();
        if(membersData.isEmpty()){
            throw new APIException("No Data Available");
        }else {
            return membersData;
        }
    }

    @Override
    public void saveMember(InstituteModule instituteModule) {
        List<InstituteModule> sameName = instituteRepository.findByName(instituteModule.getName());
        if(sameName.isEmpty()) {
            instituteRepository.save(instituteModule);
        }else {
            throw new APIException("Name already Exist");
        }
    }

    @Override
    public void deleteMember(Long id) {
        InstituteModule a = instituteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member","MemberId",id));

        instituteRepository.deleteById(id);
    }

    @Override
    public void updateMember(InstituteModule instituteModule, Long id) {
        InstituteModule a = instituteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Member","MemberId",id));

        a.setName(instituteModule.getName());
        instituteRepository.save(a);
    }
}
