package com.epam.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
@ComponentScan("com.epam.soap")
public class AppConfig {

    @Bean
    public SimpleJaxWsServiceExporter getExplorer() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://127.0.0.1:8081/");
        return exporter;
    }
}
