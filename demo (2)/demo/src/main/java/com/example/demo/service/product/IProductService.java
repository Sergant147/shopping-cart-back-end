package com.example.demo.service.product;

import com.example.demo.model.Product;
import com.example.demo.request.AddProductRequest;
import com.example.demo.model.Product;
import com.example.demo.request.AddProductRequest;
import com.example.demo.request.ProductUpdateRequest;

import java.util.List;
public interface IProductService {
    Product addProduct(AddProductRequest request);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);


    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);
}
