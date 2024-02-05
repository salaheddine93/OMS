package org.bs.oms.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRequestDTO {

    private String name;
    private Boolean status;
}
