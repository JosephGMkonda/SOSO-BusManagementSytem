package com.codebuddies.busservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value="BusManagement")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bus {
    @Id
    private String id;
    private String name;
    private String numberPlate;
    private String route;
    private BigDecimal price;


}
