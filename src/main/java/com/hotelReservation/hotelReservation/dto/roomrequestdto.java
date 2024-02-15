package com.hotelReservation.hotelReservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class roomrequestdto
{
    private Long hotelId;
    private String roomType;
}
