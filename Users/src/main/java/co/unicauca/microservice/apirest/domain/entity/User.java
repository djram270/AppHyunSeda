package co.unicauca.microservice.apirest.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//permitir que el objeto sea una tabla en h2

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Data
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;
    private String email;
    
    @ManyToMany (fetch = FetchType.EAGER, cascade =  CascadeType.MERGE)
    @JoinTable
    (
        name = "roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName =  "roleId"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"})
    )
    
    private List<Role> roles;
}