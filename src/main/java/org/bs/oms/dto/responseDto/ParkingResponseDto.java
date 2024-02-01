package org.bs.oms.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bs.oms.entities.Place;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingResponseDto {
    private Long id;
    private String name;
    private String color;
    private List<Place> places;
}
