/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.access.microservice;

import co.unicauca.hyunseda.admin.access.model.Category;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 *
 * @author dizu8
 */
public interface iMicroserviceCategory {
    List<Category> getCategories();
    Category getCategory(String strId);
    Category getCategoryByName(String name);
    String deleteCategory(String strId);
    String postCategory(Category category);
    String putCategory(Category category, String strId);
    List<Category> categoriesExisting (List<Category> categories);
    <T> T getData (String json, TypeReference<T> reference);
}
