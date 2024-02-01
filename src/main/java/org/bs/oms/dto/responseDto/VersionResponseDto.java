package org.bs.oms.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionResponseDto {

    private Long id;
    private String version;
    private Date date;
}
