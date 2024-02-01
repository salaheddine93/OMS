package org.bs.oms.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquadronResponseDto {

    private Long id;
    private String name;
    private String description;
}
