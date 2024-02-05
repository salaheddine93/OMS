package org.bs.oms.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionRequestDTO {

    private String version;
    private Date date;
}
