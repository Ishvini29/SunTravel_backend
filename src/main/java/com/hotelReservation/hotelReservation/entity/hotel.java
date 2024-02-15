package com.hotelReservation.hotelReservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel")
public class hotel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "hotelId")
    private Long hotelId;
    @NotBlank(message = "Hotel name cannot be blank")
    @Size(min = 3, max = 50, message = "Hotel name must be between 3 and 50 characters")
    private String hotelName;
    @NotBlank(message = "Hotel location cannot be blank")
    @Size(min = 3, max = 50, message = "Hotel location must be between 3 and 50 characters")
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<contract> contracts;

    @JsonIgnore
    @OneToMany(mappedBy  = "hotel",cascade = CascadeType.ALL)
    private List<room>rooms;



}
