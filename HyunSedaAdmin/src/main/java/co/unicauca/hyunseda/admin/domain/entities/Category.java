/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.domain.entities;

/**
 *
 * @author dizu8
 */

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    private Long categoryId;

    private String name;
    
    @Override
    public String toString() {
        return name;
    }
}