/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.access.microservice.implementation;

import co.unicauca.hyunseda.admin.access.microservice.iMicroserviceUser;
import co.unicauca.hyunseda.admin.access.model.Role;
import co.unicauca.hyunseda.admin.access.model.User;
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
public class MicroserviceUser implements iMicroserviceUser {
    private final String urlBase;
    private final HttpClient client;
    private final ObjectMapper mapper;

    public MicroserviceUser ()
    {
        urlBase = "http://localhost:8002/Users";
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        mapper = new ObjectMapper();
    }
    
    @Override
    public List<User> getUsers() {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get")).build();
        List<User> users = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            users = getData(response.body(), new TypeReference<List<User>>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return users;
    }

    @Override
    public User getUser(String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/id/" + strId)).build();
        User user = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            user = getData(response.body(), new TypeReference<User>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return user;
    }
    
    @Override
    public List<Role> getUserRole(String usermname, String password) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/role/" + usermname + "/" + password)).build();
        List<Role> users = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            users = getData(response.body(), new TypeReference<List<Role>>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return users;
    }
    
    @Override
    public Long getUserId(String usermname, String password) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/id/" + usermname + "/" + password)).build();
        Long userId = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            userId = getData(response.body(), new TypeReference<Long>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return userId;
    }
    
    @Override
    public String postUser(User p) {
        try {
            String jsonUser = mapper.writeValueAsString(p);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonUser))
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
    public String deleteUser(String strId) {
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
    public String putUser(User p, String strId) {
        try
        {
            String jsonUser = mapper.writeValueAsString(p);
            HttpRequest request = HttpRequest.newBuilder()
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonUser))
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

//    @Override
//    public String postUser(Object p) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public String putUser(Object p, String strId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
