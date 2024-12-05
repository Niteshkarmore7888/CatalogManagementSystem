package com.example.CatalogManagementSystem.transformer;

import com.example.CatalogManagementSystem.dto.requestDto.ProductRequestDto;
import com.example.CatalogManagementSystem.dto.responseDto.ProductResponseDto;
import com.example.CatalogManagementSystem.models.Product;



import java.time.LocalDate;

public class ProductTransformer {

    public static Product requestToEntity(ProductRequestDto productRequestDto) {
        return Product.builder()
                .brand(productRequestDto.getBrand())
                .category(productRequestDto.getCategory())
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .description(productRequestDto.getDescription())
                .dateAdded(LocalDate.now())
                .build();
    }
    public static ProductResponseDto entityToResponse(Product product){
        return ProductResponseDto.builder()
                .brand(product.getBrand())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .dateAdded(product.getDateAdded())
                .description(product.getDescription())
                .build();

    }
}
