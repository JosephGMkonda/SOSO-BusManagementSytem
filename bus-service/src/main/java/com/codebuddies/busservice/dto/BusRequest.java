package com.codebuddies.busservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class BusRequest {
    private String name;
    private String numberPlate;
    private String route;
    private BigDecimal price;
}
