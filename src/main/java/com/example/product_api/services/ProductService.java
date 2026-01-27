package com.example.product_api.services;

import com.example.product_api.dto.ProductDTO;
import com.example.product_api.models.Product;
import com.example.product_api.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // convert entity to DTO
    private ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }

    // convert DTO to entity
    private Product toEntity(ProductDTO productDTO) {
        return new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice());
    }

    public List<ProductDTO> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(this::toProductDTO)
                .toList();
    }

    public ProductDTO findById(Long id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return toProductDTO(product);
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return toProductDTO(savedProduct);
    }

    public void delete(Long id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        productRepository.delete(product);
    }

}
