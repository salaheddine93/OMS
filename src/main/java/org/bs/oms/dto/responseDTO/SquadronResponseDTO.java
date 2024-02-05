package org.bs.oms.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquadronResponseDTO {

    private Long id;
    private String name;
    private String description;
}
