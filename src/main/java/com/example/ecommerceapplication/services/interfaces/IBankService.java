package com.example.ecommerceapplication.services.interfaces;

import com.example.ecommerceapplication.models.CreateTransactionRequest;
import com.example.ecommerceapplication.models.GetTransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "http://BANK-SERVICE/bank/transactions")
public interface IBankService {
    @PostMapping("/transfer")
    public GetTransactionResponse transfer(@RequestBody CreateTransactionRequest transactionRequest);
}
