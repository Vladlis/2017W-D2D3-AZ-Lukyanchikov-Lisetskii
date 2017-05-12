package com.epam.webproject.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface LogoService {

    void store(MultipartFile file);

    Resource load();
}
