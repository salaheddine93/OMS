package org.bs.oms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Airbase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String latitude;
    private String longitude;
    private String surface;
    private Date creationDate;
    //@JsonIgnore
//    @OneToMany(fetch= FetchType.EAGER)
//    private List<Parking> parking = new ArrayList<>();
    @OneToMany
    private List<Squadron> squadrons = new ArrayList<>();
}
