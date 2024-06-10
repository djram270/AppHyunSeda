
package co.unicauca.hyunseda.client.access.microservice.implementation;

import co.unicauca.hyunseda.client.access.microservice.iMicroserviceTransaction;
import co.unicauca.hyunseda.client.access.model.Order;
import co.unicauca.hyunseda.client.access.model.Transaction;
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
 * @author Oscar
 */
public class MicroserviceTransaction implements iMicroserviceTransaction{
    private final String urlBase;
    private final HttpClient client;
    private final ObjectMapper mapper;
    
    public MicroserviceTransaction()
    {
        urlBase = "http://localhost:8005/Payments";
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        mapper = new ObjectMapper();
    }


    @Override
    public List<Transaction> getTransactionHistory() {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get/id/{id}")).build();
        List<Transaction> transactions = null;
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            transactions = getData(response.body(), new TypeReference<List<Transaction>>() {});
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return transactions;
    }

    @Override
    public String postTransaction(Transaction transaction) {
        try {
            String jsonTransaction = mapper.writeValueAsString(transaction);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonTransaction))
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
