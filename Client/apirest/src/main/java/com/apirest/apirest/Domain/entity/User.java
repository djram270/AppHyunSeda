package com.apirest.apirest.Domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    @JsonIgnore
    @Transient
    @JsonSerialize(as = Role.class)
    private List<Role> role;
}