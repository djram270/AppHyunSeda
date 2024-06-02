package com.apirest.apirest.access.model;

import java.util.List;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class User {

    private String username;
    private String password;
    private String email;
    @Transient
    private List<Role> role;
}