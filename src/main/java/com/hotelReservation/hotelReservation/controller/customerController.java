package com.hotelReservation.hotelReservation.controller;


import com.hotelReservation.hotelReservation.service.customerService;
import com.hotelReservation.hotelReservation.entity.customer;
import com.hotelReservation.hotelReservation.service.hotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class customerController
{
    @Autowired
    private customerService customerService;
    @PostMapping("/customers")
    public customer saveCustomer( @Valid @RequestBody customer customers )
    {
        return customerService.saveCustomer(customers);
    }
}
