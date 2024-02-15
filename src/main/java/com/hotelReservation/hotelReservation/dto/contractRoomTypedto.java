package com.hotelReservation.hotelReservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class contractRoomTypedto
{
    private Long roomType;
    private Long price;
    private Integer noOfRooms;
    private Integer noOfAdults;
}
