package com.alekseysamoylov.insurers.controllers;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by alekseysamoylov on 6/20/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appTestContext.xml", "classpath:dispatcher-servlet.xml"})
@WebAppConfiguration
public class TestControllers {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
        mockMvc.perform(get("/insurer/2")).andExpect(status().isOk());
        mockMvc.perform(get("/graph/2+9")).andExpect(status().isOk());
        mockMvc.perform(get("/graph/get/5+11")).andExpect(status().isOk());

    }

    @Test
    public void testJson() throws Exception {
        System.out.println(mockMvc.perform(get("/graph/get/5+11")).andReturn().getResponse().getContentAsString());

    }

}
