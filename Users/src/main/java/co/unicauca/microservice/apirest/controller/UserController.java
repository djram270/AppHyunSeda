package co.unicauca.microservice.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.unicauca.microservice.apirest.domain.entity.User;
import co.unicauca.microservice.apirest.domain.entity.Role;
import co.unicauca.microservice.apirest.domain.service.iUserService;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Users")
@RequiredArgsConstructor
public class UserController {
    //inyectar un servicio (innecesario, ahora se gestinona con @wired)
    @Autowired
    private iUserService userService;

    //@POST requiete una dependecia que no se tiene en el proyecto
    @PostMapping("/post")
    public ResponseEntity<String> postUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.postUser(user));
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<User> getProduct(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putUser(@RequestBody User user, @PathVariable Long id)
    {
        return ResponseEntity.ok(userService.putUser(user, id));
    }

    @GetMapping("/get/role/{username}/{password}")
    public ResponseEntity<List<Role>> getUserRole(@PathVariable String username, @PathVariable String password)
    {
        return ResponseEntity.ok(userService.getRole(username, password));
    }

    @GetMapping("/get/id/{username}/{password}")
    public ResponseEntity <Long> getUserId(@PathVariable String username, @PathVariable String password)
    {
        return ResponseEntity.ok(userService.getUserId(username, password));
    }
}
