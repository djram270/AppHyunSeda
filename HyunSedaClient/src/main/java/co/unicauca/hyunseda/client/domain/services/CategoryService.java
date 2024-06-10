/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.client.domain.services;

/**
 *
 * @author dizu8
 */
public class CategoryService {
    private static CategoryService categoryService;
    
    private CategoryService ()
    {
    }
    
    public static CategoryService getCategoryService ()
    {
        if (categoryService == null)
        {
            categoryService = new CategoryService();
        }
        return categoryService;
    }
    
}
