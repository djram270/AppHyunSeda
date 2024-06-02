/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.access.model;

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
    private Long userId;

    private String username;
    private String password;
    private String email;
    private List<Role> roles;
}
