package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.contractWithRoomType;
import com.hotelReservation.hotelReservation.entity.filterCondition;

import java.util.Date;
import java.util.List;

public interface contractWithRoomTypeService
{
    public contractWithRoomType addContractWithRoomType( contractWithRoomType contractWithRoomType );

    public List<contractWithRoomType> fetchcontractWithRoomTypeList();

    public List<contract> filterContracts( Date checkInDate, int numberOfNights, List<filterCondition> conditions );
    public List<contractWithRoomType> saveContractedRoomTypes(List<contractWithRoomType> contractedRoomTypes);
}
