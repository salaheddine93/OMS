package org.bs.oms.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceResponseDto {

    private Long id;
    private String name;
    private Boolean status;
}
