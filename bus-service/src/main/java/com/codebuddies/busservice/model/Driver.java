package com.codebuddies.busservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="Driver")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Driver {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String licenseNumber;

    @DBRef
    private List<BusManagement> buses;
}
