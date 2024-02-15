package com.hotelReservation.hotelReservation.controller;

import com.hotelReservation.hotelReservation.entity.hotel;
import com.hotelReservation.hotelReservation.service.hotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@CrossOrigin("*")
public class hotelController
{
    @Autowired
    private hotelService hotelService;

    //Create new hotels
    @PostMapping("/hotels")
    public hotel saveHotel( @Valid @RequestBody hotel hotels ){
        return hotelService.saveHotel(hotels);
    }

    //Fetch the hotels
    @GetMapping("/hotels")
    public List<hotel> fetchHotelList(){
        return hotelService.fetchHotelList();
    }

    //search by using location
    @GetMapping("/hotels/location/{location}")
    public List<hotel> fetchHotelByLocation(@PathVariable("location") String location){
        return hotelService.fetchHotelByLocation(location);
    }

}
