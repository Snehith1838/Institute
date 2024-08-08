package com.example.snehithModule.service;

import com.example.snehithModule.entity.InstituteModule;
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Data available");
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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Name already Exist");
        }
    }

    @Override
    public void deleteMember(Long id) {
        InstituteModule a = instituteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));

        instituteRepository.deleteById(id);
    }

    @Override
    public void updateMember(InstituteModule instituteModule, Long id) {
        InstituteModule a = instituteRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not Found"));

        a.setName(instituteModule.getName());
        instituteRepository.save(a);
    }
}
