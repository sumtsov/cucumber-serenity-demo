package com.dsumtsov.cucumber.serenity.demo.controller;

import com.dsumtsov.cucumber.serenity.demo.entity.Account;
import com.dsumtsov.cucumber.serenity.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping("/withdraw/{amount}/from/{accountId}")
    public Account withdraw(@PathVariable String amount,
                            @PathVariable Long accountId) {

        return service.withdraw(new BigDecimal(amount), accountId);
    }
}
