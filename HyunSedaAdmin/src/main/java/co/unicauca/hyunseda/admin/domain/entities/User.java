/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.domain.entities;

import java.util.List;
import lombok.*;

/**
 *
 * @author dizu8
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    Long user_id;
    String username;
    String lastname;
    String firstname;
    String country;
    String password;
    Role role;
}
