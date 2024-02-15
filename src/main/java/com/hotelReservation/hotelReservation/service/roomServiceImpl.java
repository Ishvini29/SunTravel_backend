package com.hotelReservation.hotelReservation.service;
import com.hotelReservation.hotelReservation.entity.room;
import com.hotelReservation.hotelReservation.repository.hotelRepository;
import com.hotelReservation.hotelReservation.repository.roomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class roomServiceImpl implements roomService
{
    @Autowired
    private roomRepository roomRepository;
    @Autowired
    private hotelRepository hotelRepository;
    @Override
    public room saveRoom( room rooms )
    {
        return roomRepository.save(rooms);
    }

    @Override
    public List<room> fetchRoomList() {
        return roomRepository.findAll();
    }

    @Override
    public List<room> fetchRoomListByHotelId( Long hotelId )
    {
        return roomRepository.findByHotelHotelId(hotelId);
    }

    public room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

}
