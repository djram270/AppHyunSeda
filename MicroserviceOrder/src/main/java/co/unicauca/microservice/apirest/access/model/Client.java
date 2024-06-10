package co.unicauca.microservice.apirest.access.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
    private Integer clientId;
    private String firstName;
    private String lastName;
    private String address;
}
