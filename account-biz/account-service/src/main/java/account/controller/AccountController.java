package account.controller;

import account.Account;
import account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getById/{id}")
    public Account getById(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @PostMapping("/updateById")
    public Account updateById(@RequestBody Account account) {
        accountService.updateById(account);
        return getById(account.getId());
    }

    @PostMapping("/save")
    public void save(@RequestBody Account account) {
        accountService.save(account);
    }

}
