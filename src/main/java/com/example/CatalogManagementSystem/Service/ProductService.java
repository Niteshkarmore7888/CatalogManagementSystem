package com.example.CatalogManagementSystem.Service;

import com.example.CatalogManagementSystem.Repository.ProductRepository;
import com.example.CatalogManagementSystem.dto.requestDto.ProductRequestDto;
import com.example.CatalogManagementSystem.dto.responseDto.ProductResponseDto;
import com.example.CatalogManagementSystem.exceptions.ResourceNotFoundException;
import com.example.CatalogManagementSystem.models.Product;
import com.example.CatalogManagementSystem.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        Product product= ProductTransformer.requestToEntity(productRequestDto);
        Product savedProduct =productRepository.save(product);
        return ProductTransformer.entityToResponse(savedProduct);

    }
    public ProductResponseDto getById(int id){
        Product product=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.format("No item found for given id : %d.",id)));
        ProductResponseDto productResponse=ProductTransformer.entityToResponse(product);
        return productResponse;
    }

    // method to products by brand
    public List<ProductResponseDto> getProductsByBrand(String brand){

        // trim the category
        String trimmedBrand=brand.trim();
        if(trimmedBrand.isEmpty()) throw new IllegalArgumentException("Category must not be empty.");


        List<Product> productList=productRepository.findProductsByBrand(trimmedBrand);
        // if no menu items found
        if(productList==null || productList.isEmpty()) throw new ResourceNotFoundException(String.format("No products found for brand %s .",trimmedBrand));

        // initialize product response list
        List<ProductResponseDto>productResponseList=convertProductListToProductResponseList(productList);
        return productResponseList;
    }

    // get the product of specific brand and category
    public List<ProductResponseDto> getProductsUnderGivenBrandAndCategory(String brand,String category){
        List<Product> productList=productRepository.findByBrandAndCategory(brand,category);

        // if no menu items found
        if(productList==null || productList.isEmpty()) throw new ResourceNotFoundException(String.format("No products found under brand %s and category %s .",brand,category));

        // initialize product response list
        List<ProductResponseDto>productResponseList=convertProductListToProductResponseList(productList);
        return productResponseList;

    }

    // private method to convert productList to ProductResponseList
    private List<ProductResponseDto> convertProductListToProductResponseList(List<Product> productList){
        List<ProductResponseDto>productResponseList=new ArrayList<>(productList.size());

        for(Product product:productList){
            ProductResponseDto productResponse=ProductTransformer.entityToResponse(product);
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }



    // delete product
    public String deleteProductById(int id){
        Product product=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.format("Product with id %s not found.",id)));

        productRepository.delete(product);
        return String.format("%s has removed from system database.",product.getName());

    }
}
