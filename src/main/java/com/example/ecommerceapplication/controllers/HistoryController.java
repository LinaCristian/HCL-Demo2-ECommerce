package com.example.ecommerceapplication.controllers;

import com.example.ecommerceapplication.models.GetHistoryResponse;
import com.example.ecommerceapplication.services.HistoryService;
import com.example.ecommerceapplication.services.interfaces.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/{userId}")
    public List<GetHistoryResponse> getHistory(@PathVariable String userId) {
        return historyService.getHistory(userId);
    }
}
