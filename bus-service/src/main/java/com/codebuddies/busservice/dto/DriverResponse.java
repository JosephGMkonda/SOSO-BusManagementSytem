package com.codebuddies.busservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class DriverResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String licenseNumber;
    private List<String> busIds;
}
