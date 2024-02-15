package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.customer;
import com.hotelReservation.hotelReservation.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerServiceImpl  implements customerService
{
    @Autowired
    private customerRepository customerRepository;

    @Override
    public customer saveCustomer( customer customers )
    {
        return customerRepository.save(customers);
    }
}
