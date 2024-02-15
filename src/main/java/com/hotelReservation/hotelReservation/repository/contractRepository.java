package com.hotelReservation.hotelReservation.repository;

import com.hotelReservation.hotelReservation.entity.contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface contractRepository extends JpaRepository<contract,Long>{
    public contract findByContractId(Long contractId);
    List<contract> findByStartDateLessThanEqualAndEndDateGreaterThanEqual( Date checkOutDate, Date checkInDate );
}
