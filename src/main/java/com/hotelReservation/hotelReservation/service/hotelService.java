package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.hotel;

import java.util.List;

public interface hotelService
{
    public hotel saveHotel( hotel hotels);
    public List<hotel> fetchHotelList();
    public hotel findById(Long hotelId);
    public List<hotel> fetchHotelByLocation( String location );


}
