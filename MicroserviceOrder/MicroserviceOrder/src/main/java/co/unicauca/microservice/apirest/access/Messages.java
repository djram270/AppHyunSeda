package co.unicauca.microservice.apirest.access;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;
/**
 * Clase que maneja mensajes y comunicaciones.
 *
 * Esta clase proporciona métodos para mostrar diálogos y enviar mensajes de confirmación de pago.
 */
public class Messages {

    /** URL de la API de WhatsApp */
    private static final String WHATSAPP_API_URL = "https://graph.facebook.com/v18.0/320218191168493/messages";

    /** Token de autenticación de WhatsApp */
    private static final String WHATSAPP_AUTH_TOKEN = "EAAFHuZCkZAjO4BO7MiJmJns6pBxLISDZCJbCaYCOzz5V39OeRAZAli5FzURxVToQL7qe9KZB7z726WuLiZAJQSYQTWf92fZBNAu2c4xXd0MzaBzDfr5nhUxLY010yOrH0oyyHQXvaP8Bj1AZBdZBFRqKyJWAT9ZA25M9hqgSLmDmNzhEE21cUndffAI89bTk9xACtOMxcu6jJQ1ZCPwSNMZBlexGjGY5bNcZD";

    /**
     * Muestra un cuadro de diálogo con un mensaje.
     *
     * @param message El mensaje que se desea mostrar.
     * @param title El título del cuadro de diálogo.
     */
    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un cuadro de confirmación con un mensaje.
     *
     * @param message El mensaje de confirmación.
     * @param title El título del cuadro de confirmación.
     * @return Un valor entero que representa la opción seleccionada por el usuario.
     */
    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Envía un mensaje de confirmación de pago a través de la API de WhatsApp.
     */
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