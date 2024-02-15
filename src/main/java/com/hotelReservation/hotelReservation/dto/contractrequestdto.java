package com.hotelReservation.hotelReservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class contractrequestdto
{
    private Long hotelId;
    private Long contractId;
    private Date startDate;
    private Date endDate;
    private Integer markupRate;
    private List<contractRoomTypedto> contractWithRoomType;
}
