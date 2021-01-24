package com.smartbee.crm.service;

import com.smartbee.crm.controller.req.CompanyCreateDto;
import com.smartbee.crm.controller.req.CompanyUpdateDto;
import com.smartbee.crm.service.dto.CompanyDto;

import java.util.List;

/**
 * @author Leo
 * @Date :2021/1/24
 */
public interface CompanyS {
    List<CompanyDto> getAll();
    CompanyDto getById(Integer id);
    void create(CompanyCreateDto dto);
    void multiCreate(List<CompanyCreateDto> dtoList);
    void update(CompanyUpdateDto dto);
    void delete(Integer id);

}
