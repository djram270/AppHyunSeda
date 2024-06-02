package co.unicauca.microservice.apirest.domain.service.implementation;

import co.unicauca.microservice.apirest.domain.entity.Role;
import co.unicauca.microservice.apirest.domain.service.iRoleService;
import co.unicauca.microservice.apirest.repository.iRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService implements iRoleService{
    @Autowired
    private iRoleRepository roleRepo;

    @Override
    public List<Role> getRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepo.findById(id).get();
    }

    @Override
    public String deleteRole(Long id) {
        roleRepo.deleteById(id);
        return "Role was deleted successfull";
    }

    @Override
    public String postRole(Role role) {
        roleRepo.save(role);
        return "Role was created successfull";
    }

    @Override
    public String putRole(Role role, Long id) {
        Role r = roleRepo.findById(id).orElse(null);

        if (r == null)
        {
            return "Role was not updated, an error has occurred";
        }
        role.setRoleId(r.getRoleId());
        roleRepo.save(role);
        return "Role was updated successfull";
    }
}
