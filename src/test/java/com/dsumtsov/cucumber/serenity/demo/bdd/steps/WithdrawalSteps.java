package com.dsumtsov.cucumber.serenity.demo.bdd.steps;

import com.dsumtsov.cucumber.serenity.demo.entity.Account;
import com.dsumtsov.cucumber.serenity.demo.repository.AccountRepository;
import net.thucydides.core.annotations.Step;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WithdrawalSteps {

    @LocalServerPort
    private int port;

    @MockBean
    private AccountRepository repository;

    @Autowired
    private TestRestTemplate restTemplate;

    private final Map<Long, Account> results = new HashMap<>();

    @Step
    public void clearExistingResults() {
        results.clear();
    }

    @Step
    public void withAccounts(List<Account> accounts) {
        accounts.forEach(account -> Mockito.when(repository.getById(account.getId())).thenReturn(account));
    }

    @Step
    public void withdrawFromAccount(Long accountId, BigDecimal amount) throws Exception {
        StringBuilder sb = new StringBuilder("http://localhost:")
                .append(port)
                .append("/accounts/withdraw/")
                .append(amount)
                .append("/from/")
                .append(accountId);
        Account account = restTemplate.getForObject(sb.toString(), Account.class);
        results.put(account.getId(), account);
    }

    @Step
    public void checkAccountBalance(Long accountId, BigDecimal amount, String ccy) {
        Account account = results.get(accountId);

        Assertions.assertNotNull(account);
        Assertions.assertEquals(ccy, account.getCcy());
        Assertions.assertEquals(amount, account.getAmount());
    }
}
