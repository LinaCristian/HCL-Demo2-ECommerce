package com.example.ecommerceapplication.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetProductResponse {
    private UUID id;
    private String name;
    private Integer stock;
    private Double cost;
}
