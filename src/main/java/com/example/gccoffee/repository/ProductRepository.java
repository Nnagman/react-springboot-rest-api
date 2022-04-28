package com.example.gccoffee.repository;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface ProductRepository {
    List<Product> findAll();

    Product insert(Product product);

    Optional<Product> findById(UUID productId);

    Optional<Product> findByName(String productName);

    List<Product> findByCategory(Category category);

    Product update(Product product);

    void deleteAll();
}
