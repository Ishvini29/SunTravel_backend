package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.contract;
import java.util.List;

public interface contractService
{
    public contract saveContract( contract contracts );
    public List<contract> fetchContractList();
    public void deleteContractById( Long contractId );
    public contract fetchContractById( Long contractId );
}
