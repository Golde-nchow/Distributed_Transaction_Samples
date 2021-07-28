package account.service;

import account.Account;
import account.dto.DecreaseAmountDTO;
import account.mapper.AccountMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 减少余额
     *
     * @param decreaseAmountDTO 余额信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseAmountById(DecreaseAmountDTO decreaseAmountDTO) {
        BigDecimal decreaseAmount = decreaseAmountDTO.getAmount();
        Long id = decreaseAmountDTO.getId();

        Account account = accountMapper.selectById(id);
        if (Objects.isNull(account)) {
            throw new RuntimeException("账户信息不存在");
        }

        BigDecimal amount = account.getAmount();
        if (amount.compareTo(decreaseAmount) < 0) {
            throw new RuntimeException("账户余额不足");
        }

        account.setAmount(amount.subtract(decreaseAmount));
        accountMapper.updateById(account);
    }
}
