package com.example.snehithModule.service;

import com.example.snehithModule.config.AppConstants;
import com.example.snehithModule.entity.InstituteModule;
import com.example.snehithModule.exceptions.APIException;
import com.example.snehithModule.exceptions.ResourceNotFoundException;
import com.example.snehithModule.payload.InstituteDTO;
import com.example.snehithModule.payload.InstituteResponse;
import com.example.snehithModule.repository.InstituteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class InstituteServiceImpl implements InstituteService{

    @Autowired
    private InstituteRepository instituteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InstituteResponse getAllMembers(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber,pageSize,sortByAndOrder);
        Page institutePage = instituteRepository.findAll(pageDetails);

        List<InstituteModule> membersData = institutePage.getContent();
        if(membersData.isEmpty()){
            throw new APIException("No Data Available");
        }

        List<InstituteDTO> instituteDTOS = membersData.stream()
                .map(a -> modelMapper.map(a, InstituteDTO.class))
                .toList();
        InstituteResponse instituteResponse = new InstituteResponse();
        instituteResponse.setSnehith(instituteDTOS);
        instituteResponse.setPageNumber(institutePage.getNumber());
        instituteResponse.setPageSize(institutePage.getSize());
        instituteResponse.setTotalElements(institutePage.getTotalElements());
        instituteResponse.setTotalPages(institutePage.getTotalPages());
        instituteResponse.setLastPage(institutePage.isLast());
        return instituteResponse;
    }



    @Override
    public InstituteDTO saveMember(InstituteDTO instituteDTO) {
        InstituteModule instituteModule = modelMapper.map(instituteDTO, InstituteModule.class);
        InstituteModule savedMember = instituteRepository.save(instituteModule);
        return modelMapper.map(savedMember, InstituteDTO.class);
    }



    @Override
    public InstituteDTO deleteMember(Long id) {
        InstituteModule a = instituteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member","MemberId",id));

        instituteRepository.deleteById(id);
        return modelMapper.map(a, InstituteDTO.class);
    }



    @Override
    public InstituteDTO updateMember(InstituteDTO instituteDTO, Long id) {
        InstituteModule instituteModule = modelMapper.map(instituteDTO, InstituteModule.class);
        InstituteModule a = instituteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Member","MemberId",id));

        a.setName(instituteModule.getName());
        InstituteModule updatedMember = instituteRepository.save(a);
        return modelMapper.map(updatedMember, InstituteDTO.class);
    }
}
