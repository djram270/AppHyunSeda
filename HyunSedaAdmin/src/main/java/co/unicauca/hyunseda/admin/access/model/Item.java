/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.access.model;

import lombok.*;

/**
 *
 * @author dizu8
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Item {
    private Long itemId;
    private Long productId;
    private int amount;
}
