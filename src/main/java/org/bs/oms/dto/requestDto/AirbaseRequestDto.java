package org.bs.oms.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bs.oms.entities.Parking;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirbaseRequestDto {
    
    private String name;
    private String city;
    private List<Parking> parkings = new ArrayList<>();
}
