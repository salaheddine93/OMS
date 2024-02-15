package org.bs.oms.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bs.oms.entities.Place;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingResponseDTO {
    private Long id;
    private String name;
    private String color;
    private String aircraftType;
    private int totalPlace;
    private List<Place> places;
}
