package com.example._Found.__Found_Group_Assignment.Services;

import com.example._Found.__Found_Group_Assignment.Models.Product;
import com.example._Found.__Found_Group_Assignment.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public List<Product> getAllProducts() { return productRepository.findByDeletedFalse();
    }

    // Get a product by ID
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    // Save or update a product
    public void saveProduct(Product product) {productRepository.save(product);
    }

    // Get products by category by ID
    public List<Product> getProductsByCategory(Integer categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public Product updateProduct(int id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                    product.setTaxRate(updatedProduct.getTaxRate());
                    product.setCategory(updatedProduct.getCategory());
                    product.setDeleted(updatedProduct.isDeleted());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Page<Product> findByName(String name, Pageable page) { return productRepository.findByNameContainingIgnoreCaseAndDeletedFalse(name,page); }

    public Page<Product> findByCategory(int categoryId, Pageable page) { return productRepository.findByCategoryId(categoryId, page); }

    public Page<Product> getAllProductsPageable(Pageable page) { return productRepository.findByDeletedFalse(page); }
}