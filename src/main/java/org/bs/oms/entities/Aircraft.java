package org.bs.oms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String interNumber;
    @ManyToOne
    private AircraftMaker aircraftMaker;
    @ManyToOne
    private Version version;
    @Enumerated(EnumType.STRING)
    private AircraftStatus status;
    @ManyToOne
    private Airbase airbase;
    @ManyToOne
    private Squadron squadron;
}
