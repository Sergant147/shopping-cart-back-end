package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.request.AddProductRequest;
import com.example.demo.request.ProductUpdateRequest;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final IProductService productService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("Success", products));
    }

    @GetMapping("product/{id}/product")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(new ApiResponse("Success!", product));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product) {
        try {
            Product theProduct = productService.addProduct(product);
            return ResponseEntity.ok(new ApiResponse("Success", theProduct));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(e.getMessage(), null));
        }

    }
//    2.50.08


    @PutMapping("/product/{productId}/update")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductUpdateRequest request, @PathVariable Long productId) {
        try {
            Product theProduct = productService.updateProduct(request, productId);
            return ResponseEntity.ok(new ApiResponse("Update Product success!", theProduct));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/product/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) {
        try {
            productService.deleteProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Delete product Success!", productId));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/by/brand-and-name/")
    public ResponseEntity<ApiResponse> getProductByBrandAndName(@RequestParam String brandName, @RequestParam String productName) {
        List<Product> products = productService.getProductsByBrandAndName(brandName, productName);
        if (products.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse("No such product", null));
        }
        return ResponseEntity.ok(new ApiResponse("Succcess!", products));

    }



    @GetMapping("/products/{name}/products")
    public ResponseEntity<ApiResponse> getProductByName(@PathVariable String name){
        List<Product> products = productService.getProductsByName(name);
        if (products.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse("No such product", null));
        }
        return ResponseEntity.ok(new ApiResponse("Success!", products));

    }

    @GetMapping("/products/{brand}/brand-products")
    public ResponseEntity<ApiResponse> getProductByBrand(@PathVariable String brand){
        List<Product> products = productService.getProductsByBrand(brand);
        if (products.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse("No such product", null));
        }
        return ResponseEntity.ok(new ApiResponse("Success!", products));

    }


    @GetMapping("/products/{category}/category-products")
    public ResponseEntity<ApiResponse> getProductByCategory(@PathVariable String category){
        List<Product> products = productService.getProductsByCategory(category);
        if (products.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse("No such product", null));
        }
        return ResponseEntity.ok(new ApiResponse("Success!", products));

    }







    @GetMapping("/products/{category}/{brand}/category-brand-products")
    public ResponseEntity<ApiResponse> getProductsByCategoryAndBrand(@PathVariable String category, @PathVariable String brand){
        List<Product> products = productService.getProductsByCategoryAndBrand(category, brand);
        if (products.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse("No such product", null));
        }
        return ResponseEntity.ok(new ApiResponse("Success!", products));
    }

}
