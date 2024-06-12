package co.unicauca.microservice.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación de gestión de productos.
 */
@SpringBootApplication
public class ProductsApplication {

	/**
	 * Método principal que inicia la aplicación.
	 * @param args Argumentos de la línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}
}