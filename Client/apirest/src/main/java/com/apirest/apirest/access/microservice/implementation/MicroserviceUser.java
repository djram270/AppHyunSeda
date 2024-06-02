package com.apirest.apirest.access.microservice.implementation;

import com.apirest.apirest.access.microservice.iMicroserviceUser;
import com.apirest.apirest.access.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
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
            //System.out.println(products.toString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return users;
    }

    @Override
    public User getUserById(String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/" + strId)).build();
        User users = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            users = getData(response.body(), new TypeReference<User>() {});
            //System.out.println(products.toString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return users;
    }
    
    @Override
    public String postUser(User u) {
        try {
            String jsonProduct = mapper.writeValueAsString(u);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonProduct))
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
    public String putUser(User u, String strId) {
        try
        {
            String jsonProduct = mapper.writeValueAsString(u);
            HttpRequest request = HttpRequest.newBuilder()
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonProduct))
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
}
