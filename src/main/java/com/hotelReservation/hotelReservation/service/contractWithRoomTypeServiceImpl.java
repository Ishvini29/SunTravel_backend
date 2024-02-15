package com.hotelReservation.hotelReservation.service;

import com.hotelReservation.hotelReservation.entity.contract;
import com.hotelReservation.hotelReservation.entity.contractWithRoomType;
import com.hotelReservation.hotelReservation.entity.filterCondition;
import com.hotelReservation.hotelReservation.repository.contractRepository;
import com.hotelReservation.hotelReservation.repository.contractWithRoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class contractWithRoomTypeServiceImpl implements contractWithRoomTypeService
{
    @Autowired
    private contractWithRoomTypeRepository contractWithRoomTypeRepository;
    @Autowired
    private contractRepository contractRepository;

    @Override
    public contractWithRoomType addContractWithRoomType( contractWithRoomType contractWithRoomType )
    {
        return contractWithRoomTypeRepository.save(contractWithRoomType);
    }
    @Override
    public List<contractWithRoomType> saveContractedRoomTypes(List<contractWithRoomType> contractedRoomTypes) {
        return contractWithRoomTypeRepository.saveAll(contractedRoomTypes);
    }

    @Override
    public List<contractWithRoomType> fetchcontractWithRoomTypeList()
    {
        return contractWithRoomTypeRepository.findAll();
    }
    @Override
    public List<contract> filterContracts( Date checkInDate, int numberOfNights, List<filterCondition> conditions )
    {
        //Fetch contracts based on checkInDate and numberOfNights

        LocalDate checkInLocalDate = checkInDate.toInstant().atZone( ZoneId.systemDefault()).toLocalDate();
        LocalDate checkOutLocalDate = checkInLocalDate.plusDays(numberOfNights);
        Date checkOutDate = Date.from(checkOutLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<contract> contracts=contractRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(
                checkInDate, checkOutDate);

        //Filter ContractedRoomType records by contracts
        List<contractWithRoomType> contractedRoomTypes = contractWithRoomTypeRepository.findByContractIn(contracts);

        //Group filtered records by contract
        Map<contract, List<contractWithRoomType>> groupedByContract = contractedRoomTypes.stream()
                                                                                         .collect( Collectors.groupingBy(contractWithRoomType::getContract));

        //Check conditions for each group and return contracts that satisfy all conditions
        return groupedByContract.entrySet().stream()
                                .filter(entry -> meetsConditions(entry.getValue(), conditions))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList());
    }

    private boolean meetsConditions(List<contractWithRoomType> contractedRoomTypes, List<filterCondition> conditions) {
        for (filterCondition condition : conditions) {
            boolean conditionSatisfied = contractedRoomTypes.stream()
                                                            .anyMatch(rt -> rt.getRoom().getRoomType().equals(condition.getRoomType())
                                                                                    && rt.getNoOfAdults() >= condition.getNoOfAdults()
                                                                                    && rt.getNoOfRooms() >= condition.getNoOfRooms());

            if (!conditionSatisfied) {
                return false; // If any condition is not satisfied, return false
            }
        }
        return true; // All conditions are satisfied
    }

}

