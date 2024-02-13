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

    private String name;
    private Long airbaseId;
    private Date creationDate;
    private String AircraftType;
    private String totalAircraft;
    private String description;
}
