package org.bs.oms.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bs.oms.entities.Version;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AircraftMakerResponseDTO {
    private Long id;
    private String name;
    private Boolean airForce;
    private List<Version> versions = new ArrayList<>();
}
