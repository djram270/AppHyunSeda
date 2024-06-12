package co.unicauca.microservice.apirest.outPutPort;

import co.unicauca.microservice.apirest.model.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Interfaz para el repositorio de productos.
 *
 * Esta interfaz proporciona métodos para acceder a los datos de los productos en la base de datos.
 */
@Repository
public interface iProductRepository extends JpaRepository<Product, Long> {

    /**
     * Encuentra productos por su nombre.
     *
     * @param name El nombre de los productos que se desea encontrar.
     * @return La lista de productos correspondientes al nombre especificado.
     */
    List<Product> findByName(String name);

    /**
     * Busca productos por categoría.
     *
     * @param categoryName El nombre de la categoría de los productos que se desea encontrar.
     * @return La lista de productos correspondientes a la categoría especificada.
     */
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.name = :categoryName")
    List<Product> findByCategory(String categoryName);
}
