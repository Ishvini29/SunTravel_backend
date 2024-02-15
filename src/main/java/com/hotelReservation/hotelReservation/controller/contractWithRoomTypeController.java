package com.hotelReservation.hotelReservation.controller;

import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.filterCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hotelReservation.hotelReservation.service.contractWithRoomTypeService;
import com.hotelReservation.hotelReservation.entity.contractWithRoomType;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class contractWithRoomTypeController
{
    @Autowired
    private contractWithRoomTypeService contractWithRoomTypeService;

    //create new contractWithRoomType
    @PostMapping("/contractWithRoomType")
    public contractWithRoomType addContractedRoomType( @RequestBody contractWithRoomType contractWithRoomType ) {
        return contractWithRoomTypeService.addContractWithRoomType(contractWithRoomType);
    }

    //Fetch all the contractWithRoomType
    @GetMapping("/contractWithRoomType")
    public List<contractWithRoomType>fetchcontractWithRoomTypeList() {
        return contractWithRoomTypeService.fetchcontractWithRoomTypeList();
    }

    //Filter contractWithRoomType
    @PostMapping("/contractWithRoomType/filter")
    public List<contract> filterContractWithRoomType(
            @RequestParam("checkInDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate,
            @RequestParam("numberOfNights") int numberOfNights,
            @RequestBody List<filterCondition> conditions) {

        return contractWithRoomTypeService.filterContracts( checkInDate,  numberOfNights,  conditions);
    }
}
