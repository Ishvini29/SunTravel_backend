package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.contractWithRoomType;
import com.hotelReservation.hotelReservation.repository.contractRepository;
import com.hotelReservation.hotelReservation.repository.hotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class contractServiceImpl implements contractService
{
    @Autowired
    private contractRepository contractRepository;
    @Autowired
    private contractWithRoomTypeService contractWithRoomTypeService;
    @Autowired
    private hotelRepository hotelRepository;
    @Override
    public contract saveContract( contract contracts )
    {
        // Save the Contract to generate an ID
        contract savedContract = contractRepository.save(contracts);

        // Get the generated ID
        Long contractId = savedContract.getContractId();

        // Set the Contract ID for each ContractedRoomType
        List<contractWithRoomType> contractWithRoomTypes = contracts.getContractWithRoomType();
        if (contractWithRoomTypes != null) {
            contractWithRoomTypes.forEach(contractedRoomType -> contractedRoomType.setContract(savedContract));
        }

        // Save the associated ContractedRoomType instances
        contractWithRoomTypeService.saveContractedRoomTypes( contractWithRoomTypes );
        return savedContract;
    }
    @Override
    public List<contract> fetchContractList() {
        return contractRepository.findAll();
    }

    @Override
    public void deleteContractById( Long contractId )
    {
        contractRepository.deleteById(contractId);
    }

    @Override
    public contract fetchContractById( Long contractId )
    {
        return contractRepository.findByContractId( contractId );
    }
}
