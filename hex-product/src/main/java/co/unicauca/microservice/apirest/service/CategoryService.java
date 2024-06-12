package co.unicauca.microservice.apirest.service;

import co.unicauca.microservice.apirest.inputPort.iCategoryService;
import co.unicauca.microservice.apirest.model.Category;
import co.unicauca.microservice.apirest.outPutPort.iCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Servicio para operaciones relacionadas con las categorías.
 *
 * Este servicio proporciona métodos para realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre las categorías.
 */
@Service
@RequiredArgsConstructor
public class CategoryService implements iCategoryService {

    /** Repositorio de categorías */
    @Autowired
    private iCategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Category was deleted successfully";
    }

    @Override
    public String postCategory(Category category) {
        categoryRepository.save(category);
        return "Category was created successfully";
    }

    @Override
    public String putCategory(Category category, Long id) {
        Category c = categoryRepository.findById(id).orElse(null);

        if (c == null)
        {
            return "Category was not updated, an error has occurred";
        }
        category.setCategoryId(c.getCategoryId());
        categoryRepository.save(category);
        return "Category was updated successfully";
    }

    @Override
    public List<Category> categoriesExisting(List<Category> categories) {
        // Recorrer las categorías enviadas con el producto
        List<Category> resCategories = new ArrayList<Category>();

        for (Category category : categories) {
            // Verificar si la categoría existe en la base de datos por su nombre
            Category existingCategory = categoryRepository.findByName(category.getName());

            // Si la categoría existe, asignarla al producto
            if (existingCategory != null) {
                resCategories.add(existingCategory);
            } else {
                // Si la categoría no existe, crearla y asignarla al producto
                Category newCategory = new Category(0L, category.getName());
                resCategories.add(newCategory);
            }
        }

        return resCategories;
    }
}