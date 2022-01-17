package com.example.ecommerceapplication.entities;

import com.example.ecommerceapplication.models.GetProductResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private Integer stock;
    private Double cost;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<History> history;

    public GetProductResponse toResponse() {
        return GetProductResponse.builder()
                .id(id)
                .cost(cost)
                .name(name)
                .stock(stock)
                .build();
    }
}
