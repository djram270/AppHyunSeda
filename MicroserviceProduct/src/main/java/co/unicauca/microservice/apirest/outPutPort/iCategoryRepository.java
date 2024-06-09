package co.unicauca.microservice.apirest.outPutPort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.unicauca.microservice.apirest.model.Category;

@Repository
public interface iCategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
