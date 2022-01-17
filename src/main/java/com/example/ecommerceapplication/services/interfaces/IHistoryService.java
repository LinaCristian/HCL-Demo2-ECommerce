package com.example.ecommerceapplication.services.interfaces;

import com.example.ecommerceapplication.models.GetHistoryResponse;

import java.util.List;
import java.util.UUID;

public interface IHistoryService {
    List<GetHistoryResponse> getHistory(String userId);
}
