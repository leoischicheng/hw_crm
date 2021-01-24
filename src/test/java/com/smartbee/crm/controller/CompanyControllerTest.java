package com.smartbee.crm.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartbee.crm.controller.req.ClientCreateDto;
import com.smartbee.crm.controller.req.ClientUpdateDto;
import com.smartbee.crm.controller.req.CompanyCreateDto;
import com.smartbee.crm.controller.req.CompanyUpdateDto;
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

import java.util.ArrayList;
import java.util.List;

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
class CompanyControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Test
    void findAll() {
        try {
            MvcResult mvcResult = mockMvc.perform(get("/company/query"))
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
            MvcResult mvcResult = mockMvc.perform(get("/company/query/1"))
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
            CompanyCreateDto createDto = new CompanyCreateDto();
            createDto.setName("TEST");
            createDto.setAddress("TEST");
            MvcResult mvcResult = mockMvc.perform(post("/company/create")
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
    void update() {
        try {
            CompanyUpdateDto updateDto = new CompanyUpdateDto();
            updateDto.setId(1);
            updateDto.setName("TEST");
            updateDto.setAddress("TEST");
            MvcResult mvcResult = mockMvc.perform(patch("/company/update")
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
            MvcResult mvcResult = mockMvc.perform(delete("/company/delete/1"))
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