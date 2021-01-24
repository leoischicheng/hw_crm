package com.smartbee.crm.service;

import com.smartbee.crm.common.constants.WebErrorCode;
import com.smartbee.crm.common.utils.ObjectMapperUtils;
import com.smartbee.crm.component.SecurityUserComponent;
import com.smartbee.crm.controller.req.ClientCreateDto;
import com.smartbee.crm.controller.req.ClientUpdateDto;
import com.smartbee.crm.controller.req.CompanyCreateDto;
import com.smartbee.crm.controller.req.CompanyUpdateDto;
import com.smartbee.crm.entity.Client;
import com.smartbee.crm.entity.Company;
import com.smartbee.crm.handler.BusinessException;
import com.smartbee.crm.repo.ClientRepo;
import com.smartbee.crm.repo.CompanyRepo;
import com.smartbee.crm.service.dto.ClientDto;
import com.smartbee.crm.service.dto.CompanyDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Service
public class ClientSI implements ClientS{
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private SecurityUserComponent userComponent;

    @Override
    public List<ClientDto> getAll() {
        List<Client> entityList = clientRepo.findAll();
        List<ClientDto> dtoList = ObjectMapperUtils.mapAll(entityList, ClientDto.class);
        return dtoList;
    }

    @Override
    public ClientDto getById(Integer id) {
        Optional<Client> opt = clientRepo.findById(id);
        if(!opt.isPresent()){
            throw new BusinessException(WebErrorCode.DATA_NOT_FOUNT_ERROR, WebErrorCode.DATA_NOT_FOUNT_ERROR.getMessage() + " : " + id);
        }
        ClientDto dto = ObjectMapperUtils.map(opt.get(), ClientDto.class);
        return dto;
    }

    @Override
    public void create(ClientCreateDto dto) {

        if(dto.getCompanyId() != null ){
            Optional<Company> companyOpt = companyRepo.findById(dto.getCompanyId());
            if(!companyOpt.isPresent()){
                throw new BusinessException(WebErrorCode.DATA_NOT_FOUNT_ERROR, WebErrorCode.DATA_NOT_FOUNT_ERROR.getMessage() + "illegal companyId  : " + dto.getCompanyId());
            }
        }
        Client entity = ObjectMapperUtils.map(dto, Client.class);
        entity.setCreatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
        entity.setUpdatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
        clientRepo.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void multiCreate(List<ClientCreateDto> dtoList) {
        List<Client> entityList = ObjectMapperUtils.mapAll(dtoList, Client.class);
        for (Client entity : entityList) {
            entity.setCreatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
            entity.setUpdatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
        }
        clientRepo.saveAll(entityList);
    }

    @Override
    public void update(ClientUpdateDto dto) {
        Optional<Client> opt = clientRepo.findById(dto.getId());
        if(!opt.isPresent()){
            throw new BusinessException(WebErrorCode.DATA_NOT_FOUNT_ERROR, WebErrorCode.DATA_NOT_FOUNT_ERROR.getMessage() + " : " + dto.getId());
        }
        Client entity = opt.get();
        BeanUtils.copyProperties(dto, entity);
        entity.setUpdatedBy(userComponent != null ? userComponent.getAuthenticatedUser().getUsername() : "SUPERUSER");
        clientRepo.save(entity);
    }

    @Override
    public void delete(Integer id) {
        Optional<Client> opt = clientRepo.findById(id);
        if(!opt.isPresent()){
            throw new BusinessException(WebErrorCode.DATA_NOT_FOUNT_ERROR, WebErrorCode.DATA_NOT_FOUNT_ERROR.getMessage() + " : " + id);
        }
        clientRepo.deleteById(id);
    }



}
