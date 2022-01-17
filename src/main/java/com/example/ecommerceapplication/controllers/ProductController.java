package com.example.ecommerceapplication.controllers;

import com.example.ecommerceapplication.models.BuyProductRequest;
import com.example.ecommerceapplication.models.GetProductResponse;
import com.example.ecommerceapplication.models.GetTransactionResponse;
import com.example.ecommerceapplication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/search")
    public List<GetProductResponse> searchProducts(@RequestParam(required = false) String search) {
        return productService.searchProducts(search);
    }

    @PostMapping("/buy")
    public GetTransactionResponse buyProduct(@RequestBody BuyProductRequest productRequest) {
        return productService.buyProduct(productRequest);
    }
}
