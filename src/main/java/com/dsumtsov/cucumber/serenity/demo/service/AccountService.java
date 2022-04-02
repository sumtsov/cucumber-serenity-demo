package com.dsumtsov.cucumber.serenity.demo.service;

import com.dsumtsov.cucumber.serenity.demo.entity.Account;

import java.math.BigDecimal;

public interface AccountService {

    Account withdraw(BigDecimal amount, Long accountId);
}
