package com.codebuddies.busservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection="BusManagement")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BusManagement {
    @Id
    private String id;
    private String name;
    private String numberPlate;
    private String route;
    private BigDecimal price;

    @DBRef
    private Driver drivers;


}
