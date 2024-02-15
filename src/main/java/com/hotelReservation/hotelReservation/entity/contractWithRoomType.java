package com.hotelReservation.hotelReservation.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contractWithRoomType")
public class contractWithRoomType
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long contractRoomtypeId;
    private Long price;
    private Integer noOfRooms;
    private Integer noOfAdults;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "contractId")
    private contract contract;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private room room;
}
