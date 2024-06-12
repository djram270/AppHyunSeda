package co.unicauca.microservice.apirest.access.microservice.implementation;

import co.unicauca.microservice.apirest.access.microservice.iMicroserviceClient;
import co.unicauca.microservice.apirest.access.model.Client;

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
public class MicroserviceClient implements iMicroserviceClient{

    private final String urlBase;
    private final HttpClient client;
    private final ObjectMapper mapper;

    public MicroserviceClient ()
    {
        urlBase = "http://localhost:8004/client";
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        mapper = new ObjectMapper();
    }

    @Override
    public List<Client> getClients() {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase)).build();
        List<Client> clients = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            clients = getData(response.body(), new TypeReference<List<Client>>() {});
            //System.out.println(products.toString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return clients;
    }

    @Override
    public Client getClient (String strId) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/" + strId)).build();
        Client clients = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            clients = getData(response.body(), new TypeReference<Client>() {});
            //System.out.println(products.toString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return clients;
    }

    @Override
    public String postClient(Client c) {
        try {
            String jsonProduct = mapper.writeValueAsString(c);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonProduct))
                    .uri(URI.create(urlBase))
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
    public String deleteClient(String strId) {
        try
        {
            HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create(urlBase + "/" + strId)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e)
        {
            return e.toString();
        }
    }
    @Override
    public String putClient(Client c, String strId) {
        try
        {
            String jsonProduct = mapper.writeValueAsString(c);
            HttpRequest request = HttpRequest.newBuilder()
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonProduct))
                    .uri(URI.create(urlBase + "/" + strId))
                    .header("Content-Type", "application/json")  // Especifica el tipo de contenido como JSON
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e)
        {
            return e.toString();
        }
    }
    /**
     * Convierte un JSON en un objeto Java usando un TypeReference.
     * @param json El JSON a ser convertido.
     * @param reference La referencia de tipo para el objeto resultante.
     * @return El objeto Java resultante.
     */
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
