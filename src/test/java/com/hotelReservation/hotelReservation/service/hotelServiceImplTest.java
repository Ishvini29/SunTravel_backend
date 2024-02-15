package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.hotel;
import com.hotelReservation.hotelReservation.entity.room;
import com.hotelReservation.hotelReservation.repository.hotelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class)
class hotelServiceImplTest
{
    @Mock
    private hotelRepository hotelRepository;
    @InjectMocks
   private hotelServiceImpl hotelServiceImpl;


    @Test
    void saveHotel()
    {
        List<contract>contractList=new ArrayList<>();
        List<room>roomList=new ArrayList<>();
        hotel newHotel=new hotel(1L,"Jetwing","Jaffna",contractList,roomList);
        when(hotelRepository.save( newHotel )).thenReturn(new hotel());
        hotel savedHotel=hotelServiceImpl.saveHotel(newHotel);
        assertEquals( savedHotel,new hotel() );
    }

    @Test
    void fetchHotelList()
    {
        hotel newHotel=new hotel();
        List<hotel>hotelList=new ArrayList<>();
        hotelList.add( newHotel );
    }

    @Test
    void findById()
    {
        List<contract>contractList=new ArrayList<>();
        List<room>roomList=new ArrayList<>();
        hotel newHotel=new hotel(1L,"Jetwing","Colombo",contractList,roomList);

        when( hotelRepository.findById(newHotel.getHotelId())).thenReturn( Optional.of(newHotel));
        hotel savedHotel=hotelServiceImpl.findById( newHotel.getHotelId());
        assertEquals( newHotel,savedHotel );
    }

    @Test
    void fetchHotelByLocation()
    {
        List<contract>contractList=new ArrayList<>();
        List<room>roomList=new ArrayList<>();
        hotel newHotel=new hotel(1L,"Jetwing","Colombo",contractList,roomList);
        List<hotel>hotelList=new ArrayList<>();
        when( hotelRepository.findByLocation(newHotel.getLocation())).thenReturn( hotelList );
        List<hotel>savedHotelList=hotelServiceImpl.fetchHotelByLocation( newHotel.getLocation());
        assertEquals( hotelList,savedHotelList );
    }
}