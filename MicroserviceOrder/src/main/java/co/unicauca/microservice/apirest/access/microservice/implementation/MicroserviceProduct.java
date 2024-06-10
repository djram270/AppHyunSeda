package co.unicauca.microservice.apirest.access.microservice.implementation;

import co.unicauca.microservice.apirest.access.microservice.iMicroserviceProduct;
import co.unicauca.microservice.apirest.access.model.Product;
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
public class MicroserviceProduct implements iMicroserviceProduct {
    private final String urlBase;
    private final HttpClient client;
    private final ObjectMapper mapper;

    public MicroserviceProduct ()
    {
        urlBase = "http://localhost:8003/Products";
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        mapper = new ObjectMapper();
    }
    @Override
    public List<Product> getProducts() {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get")).build();
        List<Product> products = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            products = getData(response.body(), new TypeReference<List<Product>>() {});
            //System.out.println(products.toString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return products;
    }

    @Override
    public Product getProduct(String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/id/" + strId)).build();
        Product product = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            product = getData(response.body(), new TypeReference<Product>() {});
            //System.out.println(products.toString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return product;
    }
    
    @Override
    public String postProduct(Product p) {
        try {
            String jsonProduct = mapper.writeValueAsString(p);
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
    public String deleteProduct(String strId) {
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
    public String putProduct(Product p, String strId) {
        try
        {
            String jsonProduct = mapper.writeValueAsString(p);
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
