package com.dsumtsov.cucumber.serenity.demo.repository;

import com.dsumtsov.cucumber.serenity.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
