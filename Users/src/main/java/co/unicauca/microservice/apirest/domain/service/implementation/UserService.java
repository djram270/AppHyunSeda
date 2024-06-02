package co.unicauca.microservice.apirest.domain.service.implementation;

import co.unicauca.microservice.apirest.domain.entity.Role;
import co.unicauca.microservice.apirest.domain.entity.User;
import co.unicauca.microservice.apirest.domain.service.iUserService;
import co.unicauca.microservice.apirest.repository.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;

//definir el crud del produt (POST, GET, UPDATE), no se edita nada en la base de datos, eso lo hace el repositorio
@Service
@RequiredArgsConstructor
public class UserService implements iUserService {
    //para inyectar las propiedades de iProductRepository a productRepository es util para fijar una instancia del repositorio al servicio, pero si la interface es implemementada en mas de un repositorio puede dar error (habria que usar  @qualifier)
    @Autowired
    private iUserRepository userRepo;

    @Override
    public List<User> getUsers() {
        //la interfaz jpa ya da metodo predeterminados para usar aqui
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    
    @Override
    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "User was deleted successfull";
    }

    @Override
    public String postUser(User user) {
        userRepo.save(user);
        return "User was created successfull";
    }

    @Override
    public String putUser(User user, Long id) {
        User u = userRepo.findById(id).get();

        if (u == null)
        {
            return "User was not updated, an error has occurred";
        }
        user.setUserId(u.getUserId());
        userRepo.save(user);
        return "User was updated successfull";
    }

    @Override
    public List<Role> getRole(String username, String password) {
        return userRepo.findRolesByUsernameAndPassword(username, password);
    }

    @Override
    public Long getUserId(String username, String password) {
        return userRepo.findUserIdByUsernameAndPassword(username, password);
    }
}