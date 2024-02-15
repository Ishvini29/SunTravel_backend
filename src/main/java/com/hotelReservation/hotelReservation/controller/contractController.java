package com.hotelReservation.hotelReservation.controller;

import com.hotelReservation.hotelReservation.dto.contractRoomTypedto;
import com.hotelReservation.hotelReservation.dto.contractrequestdto;
import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.contractWithRoomType;
import com.hotelReservation.hotelReservation.entity.hotel;
import com.hotelReservation.hotelReservation.entity.room;
import com.hotelReservation.hotelReservation.service.contractService;
import com.hotelReservation.hotelReservation.service.hotelService;
import com.hotelReservation.hotelReservation.service.roomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class contractController
{
    @Autowired
    private contractService contractService;
    @Autowired
    private hotelService hotelService;
    @Autowired
    private roomService roomService;

//    create contract
//    @PostMapping("/contracts")
//    public contract saveContract( @Valid @RequestBody contract contracts){
//        return contractService.saveContract(contracts);
//    }


    //create contract
    @PostMapping("/contracts")
    public contract saveContract( @Valid @RequestBody contractrequestdto contracts){
        hotel newHotel=hotel.builder()  //newhotel is an object
                            .hotelId(contracts.getHotelId())
                            .build();

        List<contractWithRoomType> contractWithRoomTypeList = new ArrayList<>();
        for ( contractRoomTypedto contractedRoomTypeDTO : contracts.getContractWithRoomType()) {
            room room = roomService.getRoomById(contractedRoomTypeDTO.getRoomType());

            contractWithRoomType contractWithRoomTypes = contractWithRoomType.builder()
                                                                            .price(contractedRoomTypeDTO.getPrice())
                                                                            .noOfRooms(contractedRoomTypeDTO.getNoOfRooms())
                                                                            .noOfAdults(contractedRoomTypeDTO.getNoOfAdults())
                                                                            .room(room)
                                                                            .build();
            contractWithRoomTypeList.add(contractWithRoomTypes);   //contractWithRoomType details are stored in the contractWithRoomTypeList
        }

        contract newContract=contract.builder()
                         .startDate(contracts.getStartDate())
                         .endDate(contracts.getEndDate())
                         .markupRate(contracts.getMarkupRate())
                         .contractWithRoomType(contractWithRoomTypeList)
                         .hotel(newHotel)
                         .build();
        return contractService.saveContract(newContract); //contract details are stored into the newContract Object
    }

    //Fetch the contacts
    @GetMapping("/contracts")
    public List<contract> fetchContractList(){
        return contractService.fetchContractList();
    }

    //update contract with hotelId
//    @PutMapping("/contracts/{contractId}/hotels/{hotelId}")
//    public contract updateContract(@PathVariable("contractId") Long contractId,@PathVariable("hotelId")Long hotelId){
//        return contractService.updateContract(contractId,hotelId);
//    }

    //Delete a particular contract
    @DeleteMapping("/contracts/{contractId}")
    public String deleteContractById(@PathVariable("contractId")Long contractId){
        contractService.deleteContractById(contractId);
        return "contract deleted successfully!!";
    }

    //search by using contractId
    @GetMapping("/contracts/contractId/{contractId}")
    public contract fetchContractById(@PathVariable("contractId") Long contractId){
        return contractService.fetchContractById(contractId);
    }
}


