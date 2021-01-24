package com.smartbee.crm.controller;

import com.smartbee.crm.controller.req.ClientCreateDto;
import com.smartbee.crm.controller.req.ClientUpdateDto;
import com.smartbee.crm.controller.resp.WebResp;
import com.smartbee.crm.service.ClientS;
import com.smartbee.crm.service.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Api(tags = "Client")
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientS clientS;


    @ApiOperation("Query all client")
    @GetMapping("/query")
    public WebResp<List<ClientDto>> findAll() {
        return new WebResp<List<ClientDto>>(clientS.getAll());
    }

    @ApiOperation("Query one client")
    @GetMapping("/query/{id}")

    public WebResp<ClientDto> findById(@PathVariable Integer id) {
        return new WebResp<ClientDto>(clientS.getById(id));
    }

    @ApiOperation("Create client")
    @PostMapping("/create")
    public WebResp create(@RequestBody ClientCreateDto dto) {
        clientS.create(dto);
        return new WebResp();
    }

    @ApiOperation("Create multiple client")
    @PostMapping("/create/multi")
    public WebResp multiCreate(@RequestBody List<ClientCreateDto> dtoList) {
        clientS.multiCreate(dtoList);
        return new WebResp();
    }

    @ApiOperation("Update client")
    @PatchMapping("/update")
    public WebResp update(@RequestBody ClientUpdateDto dto) {
        clientS.update(dto);
        return new WebResp();
    }

    @ApiOperation("delete client")
    @DeleteMapping("/delete/{id}")
    public WebResp delete(@PathVariable Integer id) {
        clientS.delete(id);
        return new WebResp();
    }

}
