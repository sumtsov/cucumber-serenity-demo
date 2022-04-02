package com.dsumtsov.cucumber.serenity.demo.service.impl;

import com.dsumtsov.cucumber.serenity.demo.entity.Account;
import com.dsumtsov.cucumber.serenity.demo.repository.AccountRepository;
import com.dsumtsov.cucumber.serenity.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    @Transactional
    public Account withdraw(BigDecimal amount, Long accountId) {
        Account account = repository.getById(accountId);
        BigDecimal result = account.getAmount().subtract(amount);
        account.setAmount(result);
        return account;
    }
}
