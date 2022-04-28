package com.example.gccoffee.controller.api;

import com.example.gccoffee.controller.CreateProductRequest;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1/products")
    public List<Product> productList(@RequestParam Optional<Category> category) {
        return category.map(productService::getProductByCategory)
                .orElse(productService.getAllProducts());
    }

    @PostMapping("/api/v1/product/create")
    public Product createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return productService.createProduct(
                createProductRequest.productName(),
                createProductRequest.category(),
                createProductRequest.price()
        );
    }
}
