package org.bs.oms.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceResponseDTO {

    private Long id;
    private String name;
    private Boolean status;
}
