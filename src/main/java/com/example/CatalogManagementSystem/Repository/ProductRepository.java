package com.example.CatalogManagementSystem.Repository;

import com.example.CatalogManagementSystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from products where brand = :brand",nativeQuery = true)
    List<Product> findProductsByBrand(@Param("brand") String brand);

    // using jpql query
    @Query("SELECT p FROM Product p WHERE p.brand = :brand AND p.category = :category")
    List<Product> findByBrandAndCategory(@Param("brand") String brand, @Param("category") String category);

}
