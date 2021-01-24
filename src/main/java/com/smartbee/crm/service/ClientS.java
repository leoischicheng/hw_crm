package com.smartbee.crm.service;

import com.smartbee.crm.controller.req.ClientCreateDto;
import com.smartbee.crm.controller.req.ClientUpdateDto;
import com.smartbee.crm.controller.req.CompanyCreateDto;
import com.smartbee.crm.controller.req.CompanyUpdateDto;
import com.smartbee.crm.service.dto.ClientDto;
import com.smartbee.crm.service.dto.CompanyDto;

import java.util.List;

/**
 * @author Leo
 * @Date :2021/1/24
 */
public interface ClientS {
    List<ClientDto> getAll();
    ClientDto getById(Integer id);
    void create(ClientCreateDto dto);
    void multiCreate(List<ClientCreateDto> dtoList);
    void update(ClientUpdateDto dto);
    void delete(Integer id);

}
