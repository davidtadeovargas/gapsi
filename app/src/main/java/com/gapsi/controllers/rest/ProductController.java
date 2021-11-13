package com.gapsi.controllers.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gapsi.models.Product;
import com.gapsi.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	//Capa de servicio a productos
	@Autowired
	ProductService productService;
	
	//Obtiene todos los productos
	@GetMapping("/getall")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	//Obtiene un producto por ID
	@GetMapping("/get/{id}")
	public Product getProductById(@PathVariable("id") String id){
		final Optional<Product> product = productService.findById(id);
		if(product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}
	
	//Borra un producto
	@PostMapping("/delete/{id}")
	public boolean deleteProduct(@PathVariable("id") String id) {
		productService.deleteById(id);
		return true;
	}
	
	//Si el producto no existe entonces lo crea, caso contrario solo lo actualiza
	@PostMapping("/save/{id}")
	public boolean updateProduct(@PathVariable("id") String id, @Valid @RequestBody Product product) {
		product.setId(id);
		productService.save(product);
		return true;
	}
}
