package com.smartbee.crm.service;

import com.smartbee.crm.common.constants.WebErrorCode;
import com.smartbee.crm.common.utils.ObjectMapperUtils;
import com.smartbee.crm.component.SecurityUserComponent;
import com.smartbee.crm.controller.req.CompanyCreateDto;
import com.smartbee.crm.controller.req.CompanyUpdateDto;
import com.smartbee.crm.entity.Company;
import com.smartbee.crm.handler.BusinessException;
import com.smartbee.crm.repo.CompanyRepo;
import com.smartbee.crm.service.dto.CompanyDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Service
public class CompanySI implements CompanyS{
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private SecurityUserComponent userComponent;

    @Override
    public List<CompanyDto> getAll() {
        List<Company> entityList = companyRepo.findAll();
        List<CompanyDto> dtoList = ObjectMapperUtils.mapAll(entityList, CompanyDto.class);
        return dtoList;
    }

    @Override
    public CompanyDto getById(Integer id) {
        Optional<Company> opt = companyRepo.findById(id);
        if(!opt.isPresent()){
            throw new BusinessException(WebErrorCode.DATA_NOT_FOUNT_ERROR, WebErrorCode.DATA_NOT_FOUNT_ERROR.getMessage() + " : " + id);
        }
        CompanyDto dto = ObjectMapperUtils.map(opt.get(), CompanyDto.class);
        return dto;
    }

    @Override
    public void create(CompanyCreateDto dto) {
        Company entity = ObjectMapperUtils.map(dto, Company.class);
        entity.setCreatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
        entity.setUpdatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
        companyRepo.save(entity);
    }

    @Override
    public void multiCreate(List<CompanyCreateDto> dtoList) {
        List<Company> entityList = ObjectMapperUtils.mapAll(dtoList, Company.class);
        for (Company entity : entityList) {
            entity.setCreatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
            entity.setUpdatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
        }
        companyRepo.saveAll(entityList);
    }

    @Override
    public void update(CompanyUpdateDto dto) {
        Optional<Company> opt = companyRepo.findById(dto.getId());
        if(!opt.isPresent()){
            throw new BusinessException(WebErrorCode.DATA_NOT_FOUNT_ERROR, WebErrorCode.DATA_NOT_FOUNT_ERROR.getMessage() + " : " + dto.getId());
        }
        Company entity = opt.get();
        BeanUtils.copyProperties(dto, entity);
        entity.setUpdatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
        companyRepo.save(entity);
    }

    @Override
    public void delete(Integer id) {
        Optional<Company> opt = companyRepo.findById(id);
        if(!opt.isPresent()){
            throw new BusinessException(WebErrorCode.DATA_NOT_FOUNT_ERROR, WebErrorCode.DATA_NOT_FOUNT_ERROR.getMessage() + " : " + id);
        }
        companyRepo.deleteById(id);
    }



}
