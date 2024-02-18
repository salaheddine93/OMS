package org.bs.oms.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bs.oms.entities.Airbase;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquadronRequestDTO {

    private Long id;
    private String name;
    private Date creationDate;
    private String aircraftType;
    private String totalAircraft;
    private String description;
}