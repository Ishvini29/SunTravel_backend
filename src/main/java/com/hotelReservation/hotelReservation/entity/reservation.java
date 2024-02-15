package com.hotelReservation.hotelReservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class reservation
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationId;
    private Date checkIn;
    private Date checkOut;

//    @ManyToOne
//    @JoinColumn(name = "customerId")
//    private customer customer;

//    @ManyToMany(mappedBy ="reservations" )
//    private Set<room> rooms=new HashSet<>();

}
