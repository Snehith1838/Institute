package com.example.snehithModule.service;

import com.example.snehithModule.entity.InstituteModule;
import com.example.snehithModule.payload.InstituteDTO;
import com.example.snehithModule.payload.InstituteResponse;

import java.util.List;

public interface InstituteService {

    InstituteResponse getAllMembers(Integer pageNumber, Integer pageSize,String sortBy,String sortOrder);

    InstituteDTO saveMember(InstituteDTO instituteDTO);

    InstituteDTO deleteMember(Long id);

    InstituteDTO updateMember(InstituteDTO instituteDTO, Long id);
}
