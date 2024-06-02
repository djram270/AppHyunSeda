package co.unicauca.microservice.apirest;

import co.unicauca.microservice.apirest.model.entity.Category;
import co.unicauca.microservice.apirest.model.entity.Product;
import co.unicauca.microservice.apirest.model.service.implementation.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductsApplicationTests {

	@Autowired
	private ProductService productService;

	/**
	 * @brief Caso de prueba para publicar un producto.
	 * Este método prueba la funcionalidad de publicar un producto utilizando el ProductService.
	 * Crea un nuevo objeto Producto, establece sus atributos, lo publica usando el productService,
	 * recupera la lista de productos y verifica si el producto publicado está presente en la lista.
	 */
	@Test
	void postProduct() {
		Product p = new Product();
		p.setProductId(12L);
		String nameProduct = "Producto de prueba nombre";
		p.setName(nameProduct);
		String descriptionProduct = "Producto de prueba description";
		p.setDescription(descriptionProduct);
		List<Category> categorias = new ArrayList<>();
		Category categoria = new Category();
		categoria.setCategoryId(12L);
		categoria.setName("ct13");
		categorias.add(categoria);
		p.setCategories(categorias);
		p.setImageLink("https://concepto.de/wp-content/uploads/2020/12/imagen-e1607991781485.jpg");
		p.setPrice(1000);

		productService.postProduct(p);

		List<Product> products = productService.getProducts();
		Product p2 = products.get(products.size() - 1);

		assertEquals(nameProduct, p2.getName(), "El nombre del producto no coincide");
		System.out.println("Se ha encontrado un producto con el nombre: " + nameProduct);

	}

	/**
	 * @brief Caso de prueba para obtener productos.
	 *
	 * Este método prueba la funcionalidad de obtener productos utilizando el ProductService.
	 * Obtiene la lista inicial de productos, cuenta la cantidad inicial de productos,
	 * agrega un nuevo producto a la lista, obtiene la lista de productos nuevamente,
	 * cuenta la cantidad de productos después de agregar uno nuevo y verifica si el número
	 * de productos aumentó correctamente. También verifica si el último producto agregado
	 * tiene el nombre esperado y muestra un mensaje de éxito si todas las comprobaciones pasan.
	 */
	@Test
	void getProducts() {

		List<Product> initialProducts = productService.getProducts();
		int initialCount = initialProducts.size();

		Product p = new Product();
		p.setProductId(12L);
		String nameProduct = "Producto de prueba nombre";
		p.setName(nameProduct);
		String descriptionProduct = "Producto de prueba description";
		p.setDescription(descriptionProduct);
		List<Category> categorias = new ArrayList<>();
		Category categoria = new Category();
		categoria.setCategoryId(12L);
		categoria.setName("ct13");
		categorias.add(categoria);
		p.setCategories(categorias);
		p.setImageLink("https://concepto.de/wp-content/uploads/2020/12/imagen-e1607991781485.jpg");
		p.setPrice(1000);
		productService.postProduct(p);


		List<Product> productsAfterAdding = productService.getProducts();
		int countAfterAdding = productsAfterAdding.size();

		assertEquals(initialCount + 1, countAfterAdding, "El número de productos no aumentó después de agregar uno nuevo");
		System.out.println("Ha aumentado un producto");

		Product lastProduct = productsAfterAdding.get(productsAfterAdding.size() - 1);

		assertEquals(nameProduct, lastProduct.getName(), "El nombre del producto recuperado no coincide");
		System.out.println("El nombre del producto si coinciden");
	}

	/**
	 * @brief Caso de prueba para eliminar un producto.
	 *
	 * Este método prueba la funcionalidad de eliminar un producto utilizando el ProductService.
	 * Obtiene la lista inicial de productos, cuenta la cantidad inicial de productos,
	 * elimina un producto de la lista utilizando el productService,
	 * obtiene la lista de productos nuevamente después de la eliminación,
	 * cuenta la cantidad de productos después de la eliminación y verifica si el número
	 * de productos disminuyó correctamente. También muestra un mensaje de éxito si todas las comprobaciones pasan.
	 */
	@Test
	void deleteProduct() {

		List<Product> initialProducts = productService.getProducts();
		int initialCount = initialProducts.size();

		productService.deleteProduct(1L);

		List<Product> productsAfterDeletion = productService.getProducts();
		int countAfterDeletion = productsAfterDeletion.size();

		assertEquals(initialCount - 1, countAfterDeletion, "El número de productos no disminuyó después de eliminar uno");
		System.out.println("Se ha eliminado un producto");
	}
}
