/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.access.microservice.implementation;

import co.unicauca.hyunseda.admin.access.microservice.iMicroserviceCategory;
import co.unicauca.hyunseda.admin.domain.entities.Category;
import co.unicauca.hyunseda.admin.domain.entities.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class MicroserviceCategory implements iMicroserviceCategory{
    private final String urlBase;
    private final HttpClient client;
    private final ObjectMapper mapper;
    private String authToken;

    public MicroserviceCategory (String authToken)
    {
        urlBase = "http://localhost:8080/Categories";
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        mapper = new ObjectMapper();
        this.authToken = authToken;
    }
    
    @Override
    public void setAuthToken (String authToken)
    {
        this.authToken = authToken;
    }

    @Override
    public List<Category> getCategories() {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get")).build();
        List<Category> Categories = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Categories = getData(response.body(), new TypeReference<List<Category>>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return Categories;
    }

    @Override
    public Category getCategory(String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/id/" + strId)).build();
        Category category = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            category = getData(response.body(), new TypeReference<Category>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return category;
    }

    @Override
    public Category getCategoryByName(String name) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/name/" + name)).build();
        Category categories = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            categories = getData(response.body(), new TypeReference<Category>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return categories;
    }
    
    @Override
    public String postCategory(Category c) {
        try {
            String jsonCategory = mapper.writeValueAsString(c);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonCategory))
                    .uri(URI.create(urlBase + "/post"))
                    .header("Content-Type", "application/json")  // Especifica el tipo de contenido como JSON
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
            return e.toString();
        }
    }

    @Override
    public String deleteCategory(String strId) {
        try
        {
            HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create(urlBase + "/delete/" + strId)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e)
        {
            return e.toString();
        }
    }

    @Override
    public String putCategory(Category c, String strId) {
        try
        {
            String jsonCategory = mapper.writeValueAsString(c);
            HttpRequest request = HttpRequest.newBuilder()
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonCategory))
                    .uri(URI.create(urlBase + "/put/" + strId))
                    .header("Content-Type", "application/json")  // Especifica el tipo de contenido como JSON
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e)
        {
            return e.toString();
        }
    }

    @Override
    public List<Category> categoriesExisting(List<Category> categories) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public <T> T getData(String json, TypeReference<T> reference) {
        try
        {
            return mapper.readValue(json, reference);
        }catch (JsonProcessingException e)
        {
            System.out.println(e.toString());
        }
        return null;
    }
}
