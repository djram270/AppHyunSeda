package co.unicauca.microservice.apirest.outPutPort;

import co.unicauca.microservice.apirest.model.Category;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz para el repositorio de categorías.
 *
 * Esta interfaz proporciona métodos para acceder a los datos de las categorías en la base de datos.
 */
@Repository
public interface iCategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Encuentra una categoría por su nombre.
     *
     * @param name El nombre de la categoría que se desea encontrar.
     * @return La categoría correspondiente al nombre especificado.
     */
    Category findByName(String name);
}