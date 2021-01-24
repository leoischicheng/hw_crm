package com.smartbee.crm.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartbee.crm.controller.req.ClientCreateDto;
import com.smartbee.crm.controller.req.ClientUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WithMockUser(username = "superuser", password = "123", authorities={"SUPERUSER"})
class ClientControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Test
    void findAll() {
        try {
            MvcResult mvcResult = mockMvc.perform(get("/client/query"))
                    .andExpect(status().isOk())
                    .andReturn();
            Assertions.assertTrue(StringUtils.isNotBlank(mvcResult.getResponse().getContentAsString()));
            log.info("http code = {}", mvcResult.getResponse().getStatus());
            log.info("body = {}", mvcResult.getResponse().getContentAsString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void findById() {
        try {
            MvcResult mvcResult = mockMvc.perform(get("/client/query/1"))
                    .andExpect(status().isOk())
                    .andReturn();
            Assertions.assertTrue(StringUtils.isNotBlank(mvcResult.getResponse().getContentAsString()));
            log.info("http code = {}", mvcResult.getResponse().getStatus());
            log.info("body = {}", mvcResult.getResponse().getContentAsString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    @Test
    void create() {
        try {
            ClientCreateDto createDto = new ClientCreateDto();
            createDto.setName("TEST");
            createDto.setEmail("TEST@gmail.com");
            createDto.setPhone("0900000000");
            createDto.setCompanyId(1);
            MvcResult mvcResult = mockMvc.perform(post("/client/create")
                    .content(JSONObject.toJSONString(createDto))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andReturn();
            Assertions.assertTrue(StringUtils.isNotBlank(mvcResult.getResponse().getContentAsString()));
            log.info("http code = {}", mvcResult.getResponse().getStatus());
            log.info("body = {}", mvcResult.getResponse().getContentAsString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void multiCreate() {
        try {
            List<ClientCreateDto> dtoList = new ArrayList();
            ClientCreateDto createDto1 = new ClientCreateDto();
            createDto1.setName("TEST");
            createDto1.setEmail("TEST@gmail.com");
            createDto1.setPhone("0900000000");
            createDto1.setCompanyId(1);
            ClientCreateDto createDto2 = new ClientCreateDto();
            createDto2.setName("TEST");
            createDto2.setEmail("TEST@gmail.com");
            createDto2.setPhone("0900000000");
            createDto2.setCompanyId(1);
            dtoList.add(createDto1);
            dtoList.add(createDto2);
            MvcResult mvcResult = mockMvc.perform(post("/client/create/multi")
                    .content(JSONObject.toJSONString(dtoList))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andReturn();
            Assertions.assertTrue(StringUtils.isNotBlank(mvcResult.getResponse().getContentAsString()));
            log.info("http code = {}", mvcResult.getResponse().getStatus());
            log.info("body = {}", mvcResult.getResponse().getContentAsString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void update() {
        try {
            ClientUpdateDto updateDto = new ClientUpdateDto();
            updateDto.setId(1);
            updateDto.setName("TEST");
            updateDto.setEmail("TEST@gmail.com");
            updateDto.setPhone("0900000000");
            updateDto.setCompanyId(1);
            MvcResult mvcResult = mockMvc.perform(patch("/client/update")
                    .content(JSONObject.toJSONString(updateDto))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andReturn();
            Assertions.assertTrue(StringUtils.isNotBlank(mvcResult.getResponse().getContentAsString()));
            log.info("http code = {}", mvcResult.getResponse().getStatus());
            log.info("body = {}", mvcResult.getResponse().getContentAsString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void deleteById() {
        try {
            MvcResult mvcResult = mockMvc.perform(delete("/client/delete/1"))
                    .andExpect(status().isOk())
                    .andReturn();
            Assertions.assertTrue(StringUtils.isNotBlank(mvcResult.getResponse().getContentAsString()));
            log.info("http code = {}", mvcResult.getResponse().getStatus());
            log.info("body = {}", mvcResult.getResponse().getContentAsString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}