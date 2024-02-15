package com.hotelReservation.hotelReservation.repository;

import com.hotelReservation.hotelReservation.entity.room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface roomRepository  extends JpaRepository<room,Long>
{
    List<room> findByHotelHotelId( Long hotelId );
}
