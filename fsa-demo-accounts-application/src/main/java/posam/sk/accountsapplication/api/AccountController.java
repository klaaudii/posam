package posam.sk.accountsapplication.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import posam.sk.accountsapplication.domain.Account;
import posam.sk.accountsapplication.domain.AccountService;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/accounts/{id}")
    public Account findById(@PathVariable Long id){
        return accountService.findById(id);
    }

    @RequestMapping("/accounts")
    public Collection<Account> findAll(){
        return accountService.findAll();
    }
}
