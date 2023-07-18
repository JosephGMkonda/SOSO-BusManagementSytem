package com.codebuddies.busservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusResponse {
    private String id;
    private String name;
    private String numberPlate;
    private String route;
    private BigDecimal price;
    private String driverId;
}
