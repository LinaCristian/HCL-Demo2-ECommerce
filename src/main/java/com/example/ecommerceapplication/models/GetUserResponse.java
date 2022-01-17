package com.example.ecommerceapplication.models;

import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetUserResponse {
    private UUID id;
    private String createdAt;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int age;
}
