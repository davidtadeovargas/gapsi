package com.gapsi.test;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.gapsi.models.Product;
import com.gapsi.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	//Inserta un producto de prueba
	@Test
	@Order(1)
    public void insertTestProduct() {
    	
		final String productId = "PROD1";
		
    	final Product product = new Product();
    	product.setId(productId);
    	product.setNombre("Producto 1");
    	product.setDescripcion("Un muy buen producto");
    	product.setModelo("PR1");
    	product.setPrecio(10);
    	
    	productService.save(product);
    	
    	Optional<Product> product_= productService.findById(productId);
    	
    	//Borra el producto de prueba creado
    	productService.deleteById(productId);
    	
    	Assert.assertNotNull(product_.get());
    }
	
	//Borra el producto de prueba
	@Test
	@Order(2)
    public void deleteTestProduct() {
    	
		final String productId = "PROD1";
				
    	final Product product = new Product();
    	product.setId(productId);
    	product.setNombre("Producto 1");
    	product.setDescripcion("Un muy buen producto");
    	product.setModelo("PR1");
    	product.setPrecio(10);
    	
    	productService.save(product);
    	
    	//Borra el producto de prueba creado
    	productService.deleteById(productId);
    	
    	Assert.assertFalse(productService.findById(productId).isPresent());
    }
	
	//Obtiene todos los productos insertados
	@Test
	@Order(3)
    public void getAllTestProduct() {
    	
		final String productId = "PROD1";
		
    	final Product product = new Product();
    	product.setId(productId);
    	product.setNombre("Producto 1");
    	product.setDescripcion("Un muy buen producto");
    	product.setModelo("PR1");
    	product.setPrecio(10);
    	
    	productService.save(product);
    	
    	final List<Product> products = productService.getAllProducts();
    	
    	//Borra el producto de prueba creado
    	productService.deleteById(productId);
    	
    	Assert.assertTrue(products.size()>0);
    }
	
	//Actualiza un producto
	@Test
	@Order(4)
    public void updateTestProduct() {
    	
		final String productId = "PROD1";
		
    	Product product = new Product();
    	product.setId(productId);
    	product.setNombre("Producto 1");
    	product.setDescripcion("Un muy buen producto");
    	product.setModelo("PR1");
    	product.setPrecio(10);
    	
    	productService.save(product);
    	
    	final String nuevaDescripcion = "Nueva descripción de producto";
    	
    	product.setDescripcion(nuevaDescripcion);
    	
    	//Actualiza el producto
    	productService.save(product);
    	
    	product = productService.findById(productId).get();
    	
    	Assert.assertTrue(product.getDescripcion().compareTo(nuevaDescripcion)==0);
    }
}
