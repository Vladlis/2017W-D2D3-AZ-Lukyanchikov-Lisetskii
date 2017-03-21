package com.epam.soap;

import com.epam.soap.service.FactorialService;
import com.epam.soap.service.FactorialService_Service;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        URL wsdl = new URL("http://127.0.0.1:8081/FactorialService?wsdl");
        FactorialService_Service service = new FactorialService_Service(wsdl);
        FactorialService factorialService = service.getFactorialService();
        System.out.println(factorialService.getFactorial(5.9));
    }
}

