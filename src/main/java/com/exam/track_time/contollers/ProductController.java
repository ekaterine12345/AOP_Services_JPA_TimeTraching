package com.exam.track_time.contollers;

import com.exam.track_time.dtos.ProductDto;
import com.exam.track_time.models.Product;
import com.exam.track_time.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public Product saveProducts(@RequestBody ProductDto productDto) {

       Product productToAdd = productService.addProduct(productDto);

        System.out.println("dto =" + productDto);
        System.out.println("model = " + productToAdd);
        return productToAdd;
    }

    @GetMapping("/findProducts")
    public List<Product> getProducts() {

        return this.productService.getProducts();
    }
}
