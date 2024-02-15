package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.contractWithRoomType;
import com.hotelReservation.hotelReservation.entity.hotel;
import com.hotelReservation.hotelReservation.entity.room;
import com.hotelReservation.hotelReservation.repository.contractRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class)
class contractServiceImplTest
{
    @Mock
    private contractRepository contractRepository;
    @Mock
    private contractWithRoomTypeServiceImpl contractWithRoomTypeServiceImpl;

    @InjectMocks
    private contractServiceImpl contractServiceImpl;

    @Test
    void saveContract()
    {
        List<contractWithRoomType> contractWithRoomTypeList=new ArrayList<>();
        hotel newHotel = new hotel();
        Date startDate = new Date();
        Date endDate = new Date();

        contract newContract=new contract(1L,startDate,endDate,12,newHotel,contractWithRoomTypeList);
        when(contractRepository.save( newContract )).thenReturn(new contract());
        List<contractWithRoomType> mockRoomTypeList = new ArrayList<>();
        when(contractWithRoomTypeServiceImpl.saveContractedRoomTypes(anyList())).thenReturn(mockRoomTypeList);
        contract savedContract=contractServiceImpl.saveContract( newContract );
        assertEquals( savedContract,new contract());
    }

    @Test
    void fetchContractList()
    {
        contract newContract=new contract();
        List<contract>contractList=new ArrayList<>();
        contractList.add( newContract );
    }

    @Test
    void fetchContractById()
    {
     List<contractWithRoomType> contractWithRoomTypeList=new ArrayList<>();
        hotel newHotel = new hotel();
        Date startDate = new Date();
        Date endDate = new Date();

        contract newContract=new contract(1L,startDate,endDate,12,newHotel,contractWithRoomTypeList);
        when( contractRepository.findByContractId(newContract.getContractId())).thenReturn((newContract));
        contract savedContract=contractServiceImpl.fetchContractById( newContract.getContractId());
        assertEquals( newContract,savedContract );
    }
}