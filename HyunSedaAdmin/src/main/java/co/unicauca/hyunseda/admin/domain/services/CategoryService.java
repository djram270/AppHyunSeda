/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.domain.services;

import co.unicauca.hyunseda.admin.access.microservice.iMicroserviceCategory;
import co.unicauca.hyunseda.admin.access.microservice.implementation.MicroserviceCategory;
import co.unicauca.hyunseda.admin.domain.entities.Category;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author dizu8
 */
public class CategoryService {
    private static CategoryService categoryService;
    private static iMicroserviceCategory microserviceCategory;
    private List<Category> categories;
    private static String authToken;
    
    private CategoryService (String authToken)
    {
        this.authToken = authToken;
        microserviceCategory = new MicroserviceCategory(this.authToken);
        categories = microserviceCategory.getCategories();
    }
    
    private CategoryService ()
    {
        //evitar el uso del servicio mientras no haya token
        if (authToken != null)
        {
            microserviceCategory = new MicroserviceCategory(authToken);
            categories = microserviceCategory.getCategories();
        }
    }
    
    public static CategoryService getCategoryService (String authToken)
    {
        if (categoryService == null)
        {
            categoryService = new CategoryService(authToken);
        }
        CategoryService.authToken = authToken;
        microserviceCategory.setAuthToken(authToken);
        return categoryService;
    }
    
    public static CategoryService getCategoryService ()
    {
        if (categoryService == null)
        {
            categoryService = new CategoryService();
        }
        return categoryService;
    }
    
    //ete constructor es temporal, es para poder pasar las categorias desde el main
    public CategoryService(List<Category> categoryRegitered){
        this.categories = categoryRegitered;
    }
    
    
    public List<Category> getCategories() {
        return this.categories;
    }
    
//    //Retorna un modelo para poder actualizar un combo box con las categorias registradas
//    public DefaultComboBoxModel<String> getCategoriesModel()
//    {
//        if (categories == null)
//        {
//            return null;
//        }
//        
//        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
//        for (Category c: this.categories)
//        {
//            model.addElement(c.toString());
//        }
//        return model;
//    }
    public Category getCategoryByName(String nameCategory)
    {
        for (Category c: this.categories)
        {
            if (nameCategory.compareTo(c.toString()) == 0)
            {
                return c;
            }
        }
        return null;
    }
    
}
