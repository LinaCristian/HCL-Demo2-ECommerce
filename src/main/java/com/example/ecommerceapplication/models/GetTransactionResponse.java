package com.example.ecommerceapplication.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetTransactionResponse {
    public UUID id;
    public String createdAt;
    private GetUserResponse fromUser;
    private GetUserResponse toUser;
    private Double amount;
    private String details;
}
