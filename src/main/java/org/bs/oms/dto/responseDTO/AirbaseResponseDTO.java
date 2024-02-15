package org.bs.oms.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bs.oms.entities.Parking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirbaseResponseDTO {

    private Long id;
    private String name;
    private String city;
    private String latitude;
    private String longitude;
    private String surface;
    private Date creationDate;
    private List<Parking> parkings = new ArrayList<>();
}
