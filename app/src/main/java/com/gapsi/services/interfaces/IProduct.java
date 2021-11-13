package com.gapsi.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.gapsi.models.Product;

public interface IProduct {
	List<Product> getAllProducts();
    Optional<Product> findById(String id);
    Product save(Product std);
    void deleteById(String id);
}
