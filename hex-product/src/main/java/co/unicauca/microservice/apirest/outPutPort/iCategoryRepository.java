package co.unicauca.microservice.apirest.outPutPort;

import co.unicauca.microservice.apirest.model.Category;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface iCategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
