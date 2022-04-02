package com.dsumtsov.cucumber.serenity.demo.bdd.util;

import com.dsumtsov.cucumber.serenity.demo.entity.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class BddUtils {

    public static final String ID = "id";
    public static final String CCY = "ccy";
    public static final String BALANCE = "balance";

    private BddUtils() {
    }

    public static List<Account> createAccountsList(List<Map<String, String>> attributesList) {
        return attributesList.stream()
                .map(BddUtils::createAccount)
                .collect(Collectors.toList());
    }

    public static Account createAccount(Map<String, String> accountAttributes) {
        return new Account(
                Long.parseLong(accountAttributes.get(ID)),
                new BigDecimal(accountAttributes.get(BALANCE)),
                accountAttributes.get(CCY));
    }
}
