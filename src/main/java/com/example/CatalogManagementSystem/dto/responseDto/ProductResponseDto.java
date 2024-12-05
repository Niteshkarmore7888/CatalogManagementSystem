package com.example.CatalogManagementSystem.dto.responseDto;

import lombok.*;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {
    String name;

    String brand;

    String description;

    String category;

    float price;

    int quantity;

    LocalDate dateAdded;
}
