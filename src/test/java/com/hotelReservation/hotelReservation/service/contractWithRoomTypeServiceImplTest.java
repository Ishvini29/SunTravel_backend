package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.contractWithRoomType;
import com.hotelReservation.hotelReservation.entity.filterCondition;
import com.hotelReservation.hotelReservation.entity.hotel;
import com.hotelReservation.hotelReservation.entity.room;
import com.hotelReservation.hotelReservation.repository.contractWithRoomTypeRepository;
import com.hotelReservation.hotelReservation.repository.contractRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class)
class contractWithRoomTypeServiceImplTest
{
    @Mock
    private contractWithRoomTypeRepository contractWithRoomTypeRepository;
    @Mock
    private contractRepository contractRepository;
    @InjectMocks
    private contractWithRoomTypeServiceImpl contractWithRoomTypeServiceImpl;

    @Test
    void addContractWithRoomType()
    {
        contract contractObj=new contract();
        room roomObj=new room();
        contractWithRoomType newContractWithRoomType=new contractWithRoomType(1L,2000L,3,2,contractObj,roomObj);
        when(contractWithRoomTypeRepository.save( newContractWithRoomType )).thenReturn(new contractWithRoomType());
        contractWithRoomType savedContractWithRoomType=contractWithRoomTypeServiceImpl.addContractWithRoomType( newContractWithRoomType );
        assertEquals( savedContractWithRoomType,new contractWithRoomType());
    }

    @Test
    void saveContractedRoomTypes()
    {
        contract contractObj=new contract();
        room roomObj=new room();
        List<contractWithRoomType> contractedRoomTypeList = new ArrayList<>();
        contractedRoomTypeList.add(new contractWithRoomType(1L, 2000L, 3, 2,contractObj, roomObj));
        contractedRoomTypeList.add(new contractWithRoomType(2L, 3500L, 2, 1,contractObj, roomObj));
        when(contractWithRoomTypeRepository.saveAll(contractedRoomTypeList)).thenReturn(contractedRoomTypeList);
        List<contractWithRoomType> savedContractedRoomTypes = contractWithRoomTypeServiceImpl.saveContractedRoomTypes(contractedRoomTypeList);
        assertEquals(contractedRoomTypeList.size(), savedContractedRoomTypes.size());
        assertEquals(contractedRoomTypeList, savedContractedRoomTypes);
    }

    @Test
    void fetchcontractWithRoomTypeList()
    {
        contractWithRoomType newContractWithRoomType=new contractWithRoomType();
        List<contractWithRoomType>contractWithRoomTypeList=new ArrayList<>();
        contractWithRoomTypeList.add( newContractWithRoomType );
    }

    @Test
    void filterContracts() {
//        Date checkInDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
//        int numberOfNights = 3;
//        List<filterCondition> conditions = new ArrayList<>();
//
//        contract contract1 = new contract();
//        contract contract2 = new contract();
//        List<contract> contracts = List.of(contract1, contract2);
//
//        contractWithRoomType contractedRoomType1 = new contractWithRoomType();
//        contractedRoomType1.setContract(contract1);
//
//        contractWithRoomType contractedRoomType2 = new contractWithRoomType();
//        contractedRoomType2.setContract(contract2);
//
//        List<contractWithRoomType> contractedRoomTypes = List.of(contractedRoomType1, contractedRoomType2);
//
//        when(contractRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(
//                any(), any()))  // Use any() for date arguments
//                                .thenReturn(contracts);
//
//        when(contractWithRoomTypeRepository.findByContractIn(contracts))
//                .thenReturn(contractedRoomTypes);
//
//        List<contract> result = contractWithRoomTypeServiceImpl.filterContracts(checkInDate, numberOfNights, conditions);
//
//        assertIterableEquals(contracts, result);

    }
}