/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.client.access.model;

import lombok.*;

/**
 *
 * @author dizu8
 */
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
