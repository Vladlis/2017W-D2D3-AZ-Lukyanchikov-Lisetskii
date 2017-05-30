package com.epam.webproject.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.epam.webproject.service.LogoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class AdminControllerTest {

    @Mock
    private LogoService logoService;

    @InjectMocks
    private AdminController adminController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void testGetLogo() throws Exception {
        Path file = Paths.get("src/test/resources/logo.png");
        Resource resource = new UrlResource(file.toUri());
        when(logoService.load()).thenReturn(resource);
        MvcResult mvcResult = mockMvc.perform(get("/admin/logo"))
            .andExpect(status().isOk())
            .andReturn();
        assertArrayEquals(Files.readAllBytes(file), mvcResult.getResponse().getContentAsByteArray());
    }

    @Test
    public void testUpload() throws Exception {
        mockMvc.perform(fileUpload("/admin/upload")
                .file("file", "some img".getBytes()))
            .andExpect(status().isFound())
            .andExpect(redirectedUrl("/admin"))
            .andExpect(flash().attributeExists("isLogoUploaded"));
    }
}