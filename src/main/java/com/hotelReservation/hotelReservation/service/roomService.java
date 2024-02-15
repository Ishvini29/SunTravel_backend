package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.hotel;
import com.hotelReservation.hotelReservation.entity.room;
import java.util.List;
import java.util.Map;

public interface roomService
{
    public room saveRoom( room rooms );
    public List<room> fetchRoomList();

   public List<room> fetchRoomListByHotelId(Long hotelId);

    public room getRoomById(Long roomId);
}
