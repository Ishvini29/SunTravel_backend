package com.hotelReservation.hotelReservation.repository;

import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.contractWithRoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface contractWithRoomTypeRepository extends JpaRepository<contractWithRoomType,Long>
{
    List<contractWithRoomType> findByContractIn( List<contract> contracts );
}
