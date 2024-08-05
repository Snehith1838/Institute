package com.example.snehithModule.controller;

import com.example.snehithModule.entity.InstituteModule;
import com.example.snehithModule.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String saveMember(@RequestBody InstituteModule instituteModule){
        instituteService.saveMember(instituteModule);
        return "Member added successfully";
    }

    @DeleteMapping("/deleteMember/{id}")
    public String deleteMember(@PathVariable Long id){
        instituteService.deleteMember(id);
        return "Member deleted successfully";
    }

    @PutMapping("/update/{id}")
    public String updateMember(@RequestBody InstituteModule instituteModule,@PathVariable Long id){
        instituteService.updateMember(instituteModule,id);
        return "Member Updated successfully";
    }
}
