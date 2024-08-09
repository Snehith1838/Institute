package com.example.snehithModule.controller;

import com.example.snehithModule.config.AppConstants;
import com.example.snehithModule.payload.InstituteDTO;
import com.example.snehithModule.payload.InstituteResponse;
import com.example.snehithModule.service.InstituteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;


    //Example of using requesting parameter
    @GetMapping("/echo")
    public ResponseEntity<String> echoMessage(@RequestParam(name = "inputMessage", defaultValue = "Hii Bro") String message){
        return new ResponseEntity<>("Echo Message : " + message,HttpStatus.OK);
    }


    @GetMapping("/allMembers")
    public InstituteResponse getAllMembers(@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                           @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                           @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
                                           @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_ORDER, required = false) String sortOrder){
        return instituteService.getAllMembers(pageNumber,pageSize,sortBy,sortOrder);
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
