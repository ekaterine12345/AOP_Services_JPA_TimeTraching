package com.exam.track_time.services;

import com.exam.track_time.advice.TrackExecutionTime;
import com.exam.track_time.dtos.ProductDto;
import com.exam.track_time.models.Product;
import com.exam.track_time.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @TrackExecutionTime
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @TrackExecutionTime
    public Product addProduct(ProductDto productDto){
        Product product = new Product(productDto);
        return this.productRepository.save(product);
    }
}
