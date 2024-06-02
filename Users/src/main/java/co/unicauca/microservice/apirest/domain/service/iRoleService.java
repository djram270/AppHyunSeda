package co.unicauca.microservice.apirest.domain.service;

import java.util.List;

import co.unicauca.microservice.apirest.domain.entity.Role;

public interface iRoleService {
    /**
     * Obtiene todos los roles
     * @return Todos los roles existentes
     */
    List<Role> getRoles();

    /**
     * Obtiene un rol especifico dado un ID ingresado
     * @param id Id ddel rol a buscar
     * @return El rol dado el Id ingresado
     */
    Role getRoleById(Long id);

    /**
     * Elimina un rol especifico dado un Id ingresado
     * @param id Id el rol que se va a eliminar
     * @return Un mensaje indicando que se elimino el rol correctamente
     */
    String deleteRole(Long id);

    /**
     * Crea un nuevo rol
     * @param role Información del rol a crear
     * @return Un mensaje indicando que se creó correctamente el rol
     */
    String postRole(Role role);

    /**
     * Actualiza la información de un rol
     * @param role Información nueva del rol que se va a actualziar
     * @param id Id del rol al que se le va a actualizar la información
     * @return Un mensaje indicando que se actualizó correctamente
     */
    String putRole(Role role, Long id);
}
