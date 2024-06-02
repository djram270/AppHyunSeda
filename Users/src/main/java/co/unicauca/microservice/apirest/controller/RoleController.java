package co.unicauca.microservice.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.unicauca.microservice.apirest.domain.entity.Role;
import co.unicauca.microservice.apirest.domain.service.iRoleService;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Roles")
@RequiredArgsConstructor
public class RoleController {
    //inyectar un servicio (innecesario, ahora se gestinona con @wired)
    @Autowired
    private iRoleService roleService;

    //@POST requiete una dependecia que no se tiene en el proyecto
    @PostMapping("/post")
    public ResponseEntity<String> postRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.postRole(role));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id)
    {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id)
    {
        return ResponseEntity.ok(roleService.deleteRole(id));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putRole(@RequestBody Role role, @PathVariable Long id)
    {
        return ResponseEntity.ok(roleService.putRole(role, id));
    }
}
