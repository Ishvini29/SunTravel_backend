package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.contractWithRoomType;
import com.hotelReservation.hotelReservation.entity.hotel;
import com.hotelReservation.hotelReservation.entity.room;
import com.hotelReservation.hotelReservation.repository.roomRepository;
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
class roomServiceImplTest
{
    @Mock
    private roomRepository roomRepository;
    @InjectMocks
    private roomServiceImpl roomServiceImpl;

    @Test
    void saveRoom()
    {
        List<contractWithRoomType> contractWithRoomTypeList=new ArrayList<>();
        hotel newHotel =new hotel();
        room newRoom=new room(1L,"Classic",newHotel,contractWithRoomTypeList);
        when(roomRepository.save( newRoom )).thenReturn(new room());
        room savedRoom=roomServiceImpl.saveRoom(newRoom);
        assertEquals( savedRoom,new room());

    }

    @Test
    void fetchRoomList()
    {
        room newRoom=new room();
        List<room>roomList=new ArrayList<>();
        roomList.add( newRoom );
    }

    @Test
    void fetchRoomListByHotelId()
    {
        List<contractWithRoomType> contractWithRoomTypeList=new ArrayList<>();
        hotel newHotel =new hotel();
        room newRoom=new room(1L,"Classic",newHotel,contractWithRoomTypeList);

        List<room>roomList=new ArrayList<>();
        when( roomRepository.findByHotelHotelId(newHotel.getHotelId())).thenReturn( roomList );
        List<room>savedRoomList=roomServiceImpl.fetchRoomListByHotelId( newHotel.getHotelId());
        assertEquals( roomList,savedRoomList );
    }

    @Test
    void getRoomById()
    {
        List<contractWithRoomType> contractWithRoomTypeList=new ArrayList<>();
        hotel newHotel =new hotel();
        room newRoom=new room(1L,"Classic",newHotel,contractWithRoomTypeList);

        when( roomRepository.findById(newRoom.getRoomId())).thenReturn( Optional.of(newRoom));
        room savedRoom=roomServiceImpl.getRoomById( newRoom.getRoomId());
        assertEquals( newRoom,savedRoom );
    }
}