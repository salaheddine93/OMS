package org.bs.oms.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionResponseDTO {

    private Long id;
    private String version;
    private Date date;
}
