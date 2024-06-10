package co.unicauca.microservice.apirest.access.microservice;

import co.unicauca.microservice.apirest.access.model.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public interface iMicroserviceClient {
    List<Client> getClients ();
    Client getClient (String strId);
    String postClient (Client p);
    String deleteClient (String strId);
    String putClient (Client p, String strId);
    <T> T getData (String json, TypeReference<T> reference);
}
