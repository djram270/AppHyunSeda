/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.client.access.model;

import java.util.List;
import lombok.*;

/**
 *
 * @author dizu8
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Order {
    private Long orderId;
    private Long clientId;
    private String strDate;
    private String strState;
    private List<Item> items;
}
