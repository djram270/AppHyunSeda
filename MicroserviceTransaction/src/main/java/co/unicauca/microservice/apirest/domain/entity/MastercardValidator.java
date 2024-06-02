package co.unicauca.microservice.apirest.domain.entity;

public class MastercardValidator {
    public static boolean validate(String cardNumber) {
        cardNumber = cardNumber.replaceAll("\\s+", "").replaceAll("-", "");

        if (!cardNumber.startsWith("5") || cardNumber.length() != 16) {
            return false;
        }
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit % 10 + 1;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        return sum % 10 == 0;
    }
}
