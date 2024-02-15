package com.hotelReservation.hotelReservation.service;
import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.hotel;
import com.hotelReservation.hotelReservation.repository.hotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class hotelServiceImpl implements hotelService
{
    @Autowired
    private hotelRepository hotelRepository;
    @Override
    public hotel saveHotel( hotel hotels )
    {
        return hotelRepository.save(hotels);
    }

    @Override
    public List<hotel> fetchHotelList() {
        return hotelRepository.findAll();
    }

    @Override
    public hotel findById( Long hotelId )
    {
        return hotelRepository.findById( hotelId ).get();
    }

    @Override
    public List<hotel> fetchHotelByLocation( String location )
    {
        return hotelRepository.findByLocation(location);
    }
}
