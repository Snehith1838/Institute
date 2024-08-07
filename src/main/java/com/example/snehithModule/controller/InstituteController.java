package com.example.snehithModule.controller;

import com.example.snehithModule.entity.InstituteModule;
import com.example.snehithModule.service.InstituteService;
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
    public List<InstituteModule> getAllMembers(){
        return instituteService.getAllMembers();
    }

    @PostMapping("/addMember")
    public ResponseEntity<String> saveMember(@RequestBody InstituteModule instituteModule){
        try {
            instituteService.saveMember(instituteModule);
            return new ResponseEntity<>("Member added successfully", HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteMember/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id){
        try {
            instituteService.deleteMember(id);
            return new ResponseEntity<>("Member deleted successfully",HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMember(@RequestBody InstituteModule instituteModule, @PathVariable Long id){
        try {
            instituteService.updateMember(instituteModule, id);
            return new ResponseEntity<>("Member Updated successfully", HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
