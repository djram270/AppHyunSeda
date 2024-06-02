package co.unicauca.microservice.apirest.access;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;
/**
 * Utility class for displaying messages and sending WhatsApp API requests.
 */
public class Messages {

    private static final String WHATSAPP_API_URL = "https://graph.facebook.com/v13.0/299365229927110/messages";
    private static final String WHATSAPP_AUTH_TOKEN = "EAALpUGDBp1ABO25I4AnuI1U8sqJMpS7R8Oz5Xje9af3ZBIIWINf6RtvXY7dhevVog36om0j9euW6VrOH0dmqlP7XoC0fb06ty7pSWj62WZA50vMV61fVBVP6lZAtaznHCZC0dEGTFu3lnN6X4WC5gnA9rWArMzgBnV09ZAj0fk50dPn8b6BxlReCZAHEtHmVqHmRggwzGkATbZC4U87fcoZD";
    /**
     * Displays an information message dialog using JOptionPane.
     *
     * @param message The message to display.
     * @param title The title of the message dialog.
     */
    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Displays a confirmation dialog and returns the user's choice.
     *
     * @param message The message to display.
     * @param title The title of the confirmation dialog.
     * @return An integer representing the user's choice (JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION, etc.).
     */
    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Sends a payment confirmation message via WhatsApp API.
     *
     * @param strNumber The phone number (in string format) to send the message to (e.g., "571234567890").
     */
    public static void sendPaymentConfirmationMessage(String strNumber) {
        System.out.println(strNumber);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(WHATSAPP_API_URL))
                    .header("Authorization", "Bearer " + WHATSAPP_AUTH_TOKEN)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"messaging_product\": \"whatsapp\", \"to\": \"57"+ strNumber +"\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }"))
                    .build();
            HttpClient http = HttpClient.newHttpClient();
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
