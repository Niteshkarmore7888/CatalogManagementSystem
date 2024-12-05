package com.example.CatalogManagementSystem.Controller;

import com.example.CatalogManagementSystem.Service.ProductService;
import com.example.CatalogManagementSystem.dto.requestDto.ProductRequestDto;
import com.example.CatalogManagementSystem.dto.responseDto.ProductResponseDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto response =productService.addProduct(productRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/id{id}")
    public  ResponseEntity<ProductResponseDto> getById( @RequestParam @Min(value = 1, message = "Product ID must be greater than 0") int id){
        ProductResponseDto productResponse=productService.getById(id);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/brand")
    public ResponseEntity<List<ProductResponseDto>> getProductsByBrand(@RequestParam  @NotBlank(message = "Brand must not be empty") String brand){
        List<ProductResponseDto> res=productService.getProductsByBrand(brand);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/brand/{brand}/category/{category}")
    public ResponseEntity<List<ProductResponseDto>> getProductsUnderGivenBrandAndCategory(@PathVariable @NotBlank(message = "Brand must not be empty") String brand,@PathVariable @NotBlank(message = "Category must not be empty") String category){
        List<ProductResponseDto> res=productService.getProductsUnderGivenBrandAndCategory(brand,category);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProductById( @RequestParam  @Min(value = 1, message = "Product ID must be greater than 0")int id){

        String res=productService.deleteProductById(id);
        return ResponseEntity.ok(res);

    }


}
