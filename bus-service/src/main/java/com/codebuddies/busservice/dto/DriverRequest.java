package com.codebuddies.busservice.dto;


import com.codebuddies.busservice.model.Driver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class DriverRequest {

    private String firstName;
    private String lastName;
    private String licenseNumber;
    private List<String> busIds;
}
