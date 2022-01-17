package com.example.ecommerceapplication.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateTransactionRequest {
    private UUID fromUUID;
    private UUID toUUID;
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private String details;
}
