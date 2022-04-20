package com.dsumtsov.cucumber.serenity.demo.bdd.definitions;

import com.dsumtsov.cucumber.serenity.demo.bdd.steps.WithdrawalSteps;
import com.dsumtsov.cucumber.serenity.demo.bdd.util.BddUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class WithdrawalDefinitions {

    @Steps
    private WithdrawalSteps steps;

    @Before
    public void clearExistingResults() {
        steps.clearExistingResults();
    }

    @Given("^the following accounts are available:$")
    public void withAccounts(DataTable dataTable) {
        List<Map<String, String>> attributesList = dataTable.asMaps(String.class, String.class);
        steps.withAccounts(BddUtils.createAccountsList(attributesList));
    }

    @When("^(\\d*\\.?\\d*) USD is withdrawn from account (\\d+)$")
    public void withdrawFromAccount(String amount, long accountId) throws Exception {
        steps.withdrawFromAccount(accountId, new BigDecimal(amount));
    }

    @Then("^account (\\d+) balance should be (\\d*\\.?\\d*) USD$")
    public void checkAccountBalance(long accountId, String amount) {
        steps.checkAccountBalance(accountId, new BigDecimal(amount));
    }
}
