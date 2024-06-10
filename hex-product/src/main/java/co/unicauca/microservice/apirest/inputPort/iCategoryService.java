package co.unicauca.microservice.apirest.inputPort;

import co.unicauca.microservice.apirest.model.Category;

import java.util.List;

public interface iCategoryService {
    List<Category> getCategories();
    Category getCategory(Long id);
    Category getCategoryByName(String name);
    String deleteCategory(Long id);
    String postCategory(Category category);
    String putCategory(Category category, Long id);
    List<Category> categoriesExisting (List<Category> categories);
}
