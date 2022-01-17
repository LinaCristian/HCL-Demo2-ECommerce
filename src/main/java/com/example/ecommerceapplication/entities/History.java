package com.example.ecommerceapplication.entities;

import com.example.ecommerceapplication.models.GetHistoryResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "history")
public class History extends BaseEntity {
    private String userId;
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public GetHistoryResponse toResponse() {
        return GetHistoryResponse.builder()
                .product(product.toResponse())
                .accountNumber(accountNumber)
                .userId(userId)
                .build();
    }
}
