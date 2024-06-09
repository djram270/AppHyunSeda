package co.unicauca.microservice.apirest.outPutPort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.unicauca.microservice.apirest.model.Product;

import java.util.List;
//Para usar el repositorio y las demas cosas necesarias para product. Esto se hace para cada objeto y hay que indicar el tipo de dato de la id con el adorno entity en el model

@Repository
public interface iProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    // Método para buscar productos por categoría
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.name = :categoryName")
    List<Product> findByCategory(String categoryName);
}
