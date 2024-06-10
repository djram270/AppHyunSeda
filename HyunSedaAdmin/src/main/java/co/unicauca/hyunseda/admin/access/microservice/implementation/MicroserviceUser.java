/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.admin.access.microservice.implementation;

import co.unicauca.hyunseda.admin.access.microservice.iMicroserviceUser;
import co.unicauca.hyunseda.admin.domain.entities.AuthResponse;
import co.unicauca.hyunseda.admin.domain.entities.LoginRequest;
import co.unicauca.hyunseda.admin.domain.entities.RegisterRequest;
import co.unicauca.hyunseda.admin.domain.entities.Role;
import co.unicauca.hyunseda.admin.domain.entities.User;
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
        urlBase = "http://localhost:8080/auth";
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        mapper = new ObjectMapper();
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        try {
            String jsonRequest = mapper.writeValueAsString(loginRequest);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .uri(URI.create(urlBase + "/login"))
                    .header("Content-Type", "application/json")  // Especifica el tipo de contenido como JSON
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
            return mapper.readValue(response.body(), AuthResponse.class);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        try {
            String jsonRequest = mapper.writeValueAsString(request);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .uri(URI.create(urlBase + "/register"))
                    .header("Content-Type", "application/json")
                    .build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), AuthResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null; // O manejar el error de manera más adecuada
        }
    }
}
