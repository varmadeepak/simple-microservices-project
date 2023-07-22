package com.simpleMicroservicesAPI.organizationservice.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {
    private Long id;
    private String organizationName;
    private String organizationCode;
    private String organizationDescription;
}
