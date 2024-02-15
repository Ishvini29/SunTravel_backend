package com.hotelReservation.hotelReservation.repository;


import com.hotelReservation.hotelReservation.entity.hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface hotelRepository extends JpaRepository<hotel,Long>
{

    public List<hotel> findByLocation( String location);
}
