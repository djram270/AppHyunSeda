package co.unicauca.microservice.apirest.auth.controller;

import co.unicauca.microservice.apirest.auth.entity.User;
import co.unicauca.microservice.apirest.auth.response.AuthResponse;
import co.unicauca.microservice.apirest.auth.response.LoginRequest;
import co.unicauca.microservice.apirest.auth.response.RegisterRequest;
import co.unicauca.microservice.apirest.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register (@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User>  register (@PathVariable String name)
    {
        return ResponseEntity.ok(authService.name(name));
    }
}
