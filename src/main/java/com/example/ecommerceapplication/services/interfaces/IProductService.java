package com.example.ecommerceapplication.services.interfaces;

import com.example.ecommerceapplication.models.BuyProductRequest;
import com.example.ecommerceapplication.models.GetProductResponse;
import com.example.ecommerceapplication.models.GetTransactionResponse;

import java.util.List;

public interface IProductService {
    List<GetProductResponse> searchProducts(String search);
    GetTransactionResponse buyProduct(BuyProductRequest productRequest);
}
