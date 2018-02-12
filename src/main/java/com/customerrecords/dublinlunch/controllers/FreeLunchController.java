package com.customerrecords.dublinlunch.controllers;

import com.customerrecords.dublinlunch.services.FreeLunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FreeLunchController {

    @Autowired
    private FreeLunchService freeLunchService;

    @RequestMapping("/")
    public List returnCustomersList() {
        return freeLunchService.returnListOfCustomers();
    }
}