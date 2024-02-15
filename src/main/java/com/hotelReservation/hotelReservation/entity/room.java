package com.hotelReservation.hotelReservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class room
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;
    private String roomType;
    @ManyToOne(optional = false)
    @JoinColumn( name = "hotelId" )
    private hotel hotel;

    @JsonIgnore
    @OneToMany( mappedBy = "room", cascade = CascadeType.ALL )
    List<contractWithRoomType> contractWithRoomType;



//    @ManyToMany
//    @JoinTable(name = "room_reservation",joinColumns = @JoinColumn(name = "roomId"),inverseJoinColumns = @JoinColumn(name = "reservationId"))
//    private Set<reservation>reservations=new HashSet<>();
}
