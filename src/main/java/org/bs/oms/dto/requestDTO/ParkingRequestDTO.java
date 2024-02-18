package org.bs.oms.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bs.oms.entities.Place;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingRequestDTO {

    private Long id;
    private String name;
    private String color;
    private String aircraftType;
    private Integer totalPlaces;
    private List<Place> places;
    private String description;
}
