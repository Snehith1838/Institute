package com.example.snehithModule.controller;

import com.example.snehithModule.entity.InstituteModule;
import com.example.snehithModule.service.InstituteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @GetMapping("/allMembers")
    public Object getAllMembers(){
        try {
            return instituteService.getAllMembers();
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }


    @PostMapping("/addMember")
    public ResponseEntity<String> saveMember(@Valid @RequestBody InstituteModule instituteModule){
        try {
            instituteService.saveMember(instituteModule);
            return new ResponseEntity<>("Member added successfully", HttpStatus.CREATED);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }


    @DeleteMapping("/deleteMember/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id){
        try {
            instituteService.deleteMember(id);
            return new ResponseEntity<>("Member deleted successfully", HttpStatus.OK);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMember(@RequestBody InstituteModule instituteModule, @PathVariable Long id){
        try {
            instituteService.updateMember(instituteModule, id);
            return new ResponseEntity<>("Member Updated successfully", HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
