package com.example.ecommerceapplication.services;

import com.example.ecommerceapplication.entities.History;
import com.example.ecommerceapplication.entities.Product;
import com.example.ecommerceapplication.models.BuyProductRequest;
import com.example.ecommerceapplication.models.CreateTransactionRequest;
import com.example.ecommerceapplication.models.GetProductResponse;
import com.example.ecommerceapplication.models.GetTransactionResponse;
import com.example.ecommerceapplication.repositories.IHistoryRepository;
import com.example.ecommerceapplication.repositories.IProductRepository;
import com.example.ecommerceapplication.services.interfaces.IBankService;
import com.example.ecommerceapplication.services.interfaces.IHistoryService;
import com.example.ecommerceapplication.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IBankService bankService;
    @Autowired
    private IHistoryRepository historyRepository;
    @Value("${ecommerce.accountNumber}")
    private String accountNumber;
    @Value("${ecommerce.userId}")
    private String userId;

    @Override
    public List<GetProductResponse> searchProducts(String search) {
        List<Product> dbProducts = null;

        if(search == null)
            dbProducts = productRepository.findAll();
        else
            dbProducts = productRepository.findByNameContains(search);

        return dbProducts.stream().map(Product::toResponse).collect(Collectors.toList());
    }

    @Override
    public GetTransactionResponse buyProduct(BuyProductRequest productRequest) {
        Product dbProduct = productRepository.findById(productRequest.getProductUUID()).orElse(null);

        if(dbProduct == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid product!");

        if(dbProduct.getStock() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Out of stock!");

        GetTransactionResponse result = null;

        try {
            result = bankService.transfer(
                    CreateTransactionRequest.builder()
                            .fromUUID(productRequest.getFromUUID())
                            .fromAccount(productRequest.getFromAccountNumber())
                            .toUUID(UUID.fromString(userId))
                            .toAccount(accountNumber)
                            .amount(dbProduct.getCost())
                            .details("Buy product")
                            .build());

            dbProduct.setStock(dbProduct.getStock() - 1);
            productRepository.save(dbProduct);

            historyRepository.save(History.builder()
            .product(dbProduct)
            .accountNumber(productRequest.getFromAccountNumber())
            .userId(productRequest.getFromUUID().toString())
            .build());
        }
        catch (Exception ex) {
            String message = ex.getMessage();

            if(message.startsWith("[400]") && message.contains("No funds!"))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No funds!");
            else throw ex;
        }

       return result;
    }


}
