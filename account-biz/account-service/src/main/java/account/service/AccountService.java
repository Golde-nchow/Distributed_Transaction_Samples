package account.service;

import account.Account;
import account.dto.DecreaseAmountDTO;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AccountService extends IService<Account> {

    /**
     * 减少余额
     * @param decreaseAmountDTO 余额信息
     */
    void decreaseAmountById(DecreaseAmountDTO decreaseAmountDTO);
}
