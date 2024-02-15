
package com.hotelReservation.hotelReservation.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contract")
public class contract
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long contractId;
    private Date startDate;
    private Date endDate;
    private Integer markupRate;

    @ManyToOne
    @JoinColumn( name = "hotelId", nullable = false )
    private hotel hotel;

//    @JsonIgnore
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    List<contractWithRoomType> contractWithRoomType ;

}