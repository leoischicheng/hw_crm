package com.smartbee.crm.controller;

import com.smartbee.crm.component.SecurityUserComponent;
import com.smartbee.crm.controller.req.CompanyCreateDto;
import com.smartbee.crm.controller.req.CompanyUpdateDto;
import com.smartbee.crm.controller.resp.WebResp;
import com.smartbee.crm.entity.Company;
import com.smartbee.crm.service.CompanyS;
import com.smartbee.crm.service.dto.CompanyDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Api(tags = "Company")
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyS companyS;


    @ApiOperation("Query all company")
    @GetMapping("/query")
    public WebResp<List<CompanyDto>> findAll() {
        return new WebResp<List<CompanyDto>>(companyS.getAll());
    }

    @ApiOperation("Query one company")
    @GetMapping("/query/{id}")
    public WebResp<CompanyDto> findById(@PathVariable Integer id) {
        return new WebResp<CompanyDto>(companyS.getById(id));
    }

    @ApiOperation("Create company")
    @PostMapping("/create")
    public WebResp create(@RequestBody CompanyCreateDto dto) {
        companyS.create(dto);
        return new WebResp();
    }

    @ApiOperation("Update company")
    @PatchMapping("/update")
    public WebResp update(@RequestBody CompanyUpdateDto dto) {
        companyS.update(dto);
        return new WebResp();
    }

    @ApiOperation("delete company")
    @DeleteMapping("/delete/{id}")
    public WebResp delete(@PathVariable Integer id) {
        companyS.delete(id);
        return new WebResp();
    }

}
