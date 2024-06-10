/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.domain.entities;

import lombok.*;

/**
 *
 * @author dizu8
 */
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Order {
    private Long orderId;
    private Long clientId;
    private String date;
    private String strState;
}
