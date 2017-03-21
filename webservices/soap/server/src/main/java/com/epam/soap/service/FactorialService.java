package com.epam.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.epam.soap.util.Utils;

@Service
@WebService(serviceName = "FactorialService", portName = "FactorialService")
public class FactorialService {

    @WebMethod
    public double getFactorial(double value) {
        return Utils.calculateFactorial(value);
    }
}