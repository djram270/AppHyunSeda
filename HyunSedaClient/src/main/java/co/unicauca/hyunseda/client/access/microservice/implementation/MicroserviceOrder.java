/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.client.access.microservice.implementation;

import co.unicauca.hyunseda.client.access.microservice.iMicroserviceOrder;
import co.unicauca.hyunseda.client.access.model.Order;
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
public class MicroserviceOrder implements iMicroserviceOrder{
    private final String urlBase;
    private final HttpClient client;
    private final ObjectMapper mapper;

    public MicroserviceOrder ()
    {
        urlBase = "http://localhost:8001/Orders";
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        mapper = new ObjectMapper();
    }
    
    @Override
    public List<Order> getOrders() {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get")).build();
        List<Order> orders = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            orders = getData(response.body(), new TypeReference<List<Order>>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return orders;
    }

    @Override
    public Order getOrder(String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/id/" + strId)).build();
        Order order = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            order = getData(response.body(), new TypeReference<Order>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return order;
    }
    
    @Override
    public List<Order> getOrdersByStrState(String strState) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/state/" + strState)).build();
        List<Order> orders = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            orders = getData(response.body(), new TypeReference<List<Order>>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return orders;
    }
    
    @Override
    public String postOrder(Order p) {
        try {
            String jsonOrder = mapper.writeValueAsString(p);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonOrder))
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
    public String deleteOrder(String strId) {
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
    public String putOrder(Order p, String strId) {
        try
        {
            String jsonOrder = mapper.writeValueAsString(p);
            HttpRequest request = HttpRequest.newBuilder()
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonOrder))
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
    public String executeNotSendInOrder(String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/execute/NotSend/" + strId)).build();
        String strResponse = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            strResponse = getData(response.body(), new TypeReference<String>() {});
            System.out.println(strResponse);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return strResponse;
    }

    @Override
    public String executeOnHoldInOrder(String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/execute/OnHold/" + strId)).build();
        String strResponse = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            strResponse = getData(response.body(), new TypeReference<String>() {});
            System.out.println(strResponse);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return strResponse;
    }

    @Override
    public String executeSendInOrder(String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/execute/Send/" + strId)).build();
        String strResponse = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            strResponse = getData(response.body(), new TypeReference<String>() {});
            System.out.println(strResponse);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return strResponse;
    }

    @Override
    public String executeCancelInOrder(String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/execute/Cancel/" + strId)).build();
        String strResponse = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            strResponse = getData(response.body(), new TypeReference<String>() {});
            System.out.println(strResponse);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return strResponse;
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
