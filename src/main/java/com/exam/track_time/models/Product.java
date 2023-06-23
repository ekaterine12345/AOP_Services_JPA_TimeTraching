package com.exam.track_time.models;

import com.exam.track_time.dtos.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @SequenceGenerator(name = "productIdSeq", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productIdSeq")

    private Long Id;
    private String name;
    private float price;

    public Product(ProductDto productDto) {
        this.name = productDto.getName();
        this.price = productDto.getPrice();
    }
}
