package com.hotelReservation.hotelReservation.controller;
import com.hotelReservation.hotelReservation.dto.roomrequestdto;
import com.hotelReservation.hotelReservation.entity.hotel;
import com.hotelReservation.hotelReservation.entity.room;
import com.hotelReservation.hotelReservation.service.roomService;
import com.hotelReservation.hotelReservation.service.hotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class roomController
{
    @Autowired
    private roomService roomService;
    @Autowired
    private hotelService hotelService;

    //create room
    @PostMapping("/rooms")
    public room saveRoom( @Valid @RequestBody roomrequestdto rooms){
        hotel newHotel=hotel.builder()  //newhotel is an object
                            .hotelId(rooms.getHotelId())
                            .build();

        room newRoom=room.builder()
                          .roomType(rooms.getRoomType())
                          .hotel(newHotel)
                          .build();
        return roomService.saveRoom(newRoom);
    }

    //Fetch all the room details
    @GetMapping("/rooms")
    public List<room> fetchRoomList(){
        return roomService.fetchRoomList();
    }

@GetMapping("/rooms/hotelId/{hotelId}")
    public List<room>fetchRoomListById(@PathVariable Long hotelId){
        return roomService.fetchRoomListByHotelId(hotelId);}
}



