package org.bs.oms.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bs.oms.entities.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AircraftRequestDTO {

    private String name;
    private String interNumber;
    private AircraftMaker aircraftMaker;
    private Version version;
    private AircraftStatus status;
    private Airbase airbase;
    private Squadron squadron;
}
