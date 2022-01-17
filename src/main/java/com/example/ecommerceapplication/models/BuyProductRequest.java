package com.example.ecommerceapplication.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BuyProductRequest {
    private UUID fromUUID;
    private String fromAccountNumber;
    private UUID productUUID;
}
