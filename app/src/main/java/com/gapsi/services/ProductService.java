package com.gapsi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gapsi.models.Product;
import com.gapsi.repositories.ProductRepository;
import com.gapsi.services.interfaces.IProduct;

@Service
public class ProductService implements IProduct {

    @Autowired
    private ProductRepository productRepository;

    
    @Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(String id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		
		final Optional<Product> product_ = productRepository.findById(product.getId());
		if(product_.isPresent()) {
			product.setId(product_.get().getId());
			product.setNombre(product_.get().getNombre());
			product.setPrecio(product_.get().getPrecio());
		}
		
		return productRepository.save(product);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		final Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.delete(product.get());
		}
	}
}
