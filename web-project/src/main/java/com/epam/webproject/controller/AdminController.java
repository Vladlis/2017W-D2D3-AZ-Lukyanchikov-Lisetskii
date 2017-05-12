package com.epam.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.epam.webproject.service.LogoService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private LogoService logoService;

    @RequestMapping("/logo")
    @ResponseBody
    public ResponseEntity<Resource> getLogo() {
        Resource file = logoService.load();
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadLogo(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        logoService.store(file);
        redirectAttributes.addFlashAttribute("isLogoUploaded", "true");
        return "redirect:/admin";
    }
}
