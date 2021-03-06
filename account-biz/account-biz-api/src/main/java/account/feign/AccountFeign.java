package account.feign;

import account.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-service")
public interface AccountFeign {

    @GetMapping("/account/getById/{id}")
    Account getById(@PathVariable(value = "id") Long id);

    @GetMapping("/account/updateById")
    Account updateById(@RequestBody Account account);

    @PostMapping("/account/save")
    void save(@RequestBody Account account);

}
