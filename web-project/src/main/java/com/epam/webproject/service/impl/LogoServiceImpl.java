package com.epam.webproject.service.impl;

import com.epam.webproject.service.LogoService;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;

@Service
public class LogoServiceImpl implements LogoService, InitializingBean {

    private final Path rootLocation = Paths.get("logo_folder/");
    private String filename;

    @Override
    public void store(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file " + originalFilename);
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(originalFilename), StandardCopyOption.REPLACE_EXISTING);
            filename = originalFilename;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + originalFilename, e);
        }
    }

    @Override
    public Resource load() {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new RuntimeException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!Files.exists(rootLocation)) {
            Files.createDirectory(rootLocation);
        }
    }
}
