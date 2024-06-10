package co.unicauca.microservice.apirest.access;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;

public class Messages {

    private static final String WHATSAPP_API_URL = "https://graph.facebook.com/v18.0/320218191168493/messages";
    private static final String WHATSAPP_AUTH_TOKEN = "EAAFHuZCkZAjO4BO7MiJmJns6pBxLISDZCJbCaYCOzz5V39OeRAZAli5FzURxVToQL7qe9KZB7z726WuLiZAJQSYQTWf92fZBNAu2c4xXd0MzaBzDfr5nhUxLY010yOrH0oyyHQXvaP8Bj1AZBdZBFRqKyJWAT9ZA25M9hqgSLmDmNzhEE21cUndffAI89bTk9xACtOMxcu6jJQ1ZCPwSNMZBlexGjGY5bNcZD";


    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void sendPaymentConfirmationMessage() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(WHATSAPP_API_URL))
                    .header("Authorization", "Bearer " + WHATSAPP_AUTH_TOKEN)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"messaging_product\": \"whatsapp\", \"to\": \"573218500170\", \"type\": \"template\", \"template\": { \"name\": \"pruebapago\", \"language\": { \"code\": \"es\" } } }"))
                    .build();
            HttpClient http = HttpClient.newHttpClient();
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
