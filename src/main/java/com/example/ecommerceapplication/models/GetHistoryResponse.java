package com.example.ecommerceapplication.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetHistoryResponse {
    private String userId;
    private String accountNumber;
    private GetProductResponse product;
}
