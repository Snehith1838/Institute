package com.example.snehithModule.controller;

import com.example.snehithModule.entity.InstituteModule;
import com.example.snehithModule.payload.InstituteDTO;
import com.example.snehithModule.payload.InstituteResponse;
import com.example.snehithModule.service.InstituteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @GetMapping("/allMembers")
    public InstituteResponse getAllMembers(){
        return instituteService.getAllMembers();
    }


    @PostMapping("/addMember")
    public ResponseEntity<InstituteDTO> saveMember(@Valid @RequestBody InstituteDTO instituteDTO){
        InstituteDTO savedMember = instituteService.saveMember(instituteDTO);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteMember/{id}")
    public ResponseEntity<InstituteDTO> deleteMember(@PathVariable Long id){
        InstituteDTO deletedMember = instituteService.deleteMember(id);
        return new ResponseEntity<>(deletedMember, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<InstituteDTO> updateMember(@RequestBody InstituteDTO instituteDTO, @PathVariable Long id){
        InstituteDTO updatedMember = instituteService.updateMember(instituteDTO, id);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }
}
