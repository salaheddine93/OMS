package org.bs.oms.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bs.oms.entities.Airbase;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquadronResponseDTO {

    private Long id;
    private String name;
    private Airbase airbase;
    private Date creationDate;
    private String AircraftType;
    private String totalAircraft;
    private String description;
}
