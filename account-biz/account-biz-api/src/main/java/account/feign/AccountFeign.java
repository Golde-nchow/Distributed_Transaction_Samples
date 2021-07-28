package account.feign;

import account.Account;
import account.dto.DecreaseAmountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name = "account-service")
public interface AccountFeign {

    @GetMapping("/account/getById/{id}")
    Account getById(@PathVariable(value = "id") Long id);

    @GetMapping("/account/updateById")
    Account updateById(@RequestBody Account account);

    @PostMapping("/account/save")
    void save(@RequestBody Account account);

    @PostMapping("/account/decreaseAmountById")
    void decreaseAmountById(@RequestBody DecreaseAmountDTO decreaseAmountDTO);
}
