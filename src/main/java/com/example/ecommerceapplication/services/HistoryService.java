package com.example.ecommerceapplication.services;

import com.example.ecommerceapplication.entities.History;
import com.example.ecommerceapplication.models.GetHistoryResponse;
import com.example.ecommerceapplication.repositories.IHistoryRepository;
import com.example.ecommerceapplication.services.interfaces.IHistoryService;
import com.example.ecommerceapplication.services.interfaces.IProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HistoryService implements IHistoryService {
    @Autowired
    private IHistoryRepository historyRepository;

    @Override
    public List<GetHistoryResponse> getHistory(String userId) {
        List<History> dbHistory = historyRepository.findByUserId(userId);
        return dbHistory.stream().map(History::toResponse).collect(Collectors.toList());
    }
}
