package account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DecreaseAmountDTO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 余额
     */
    private BigDecimal amount;

}
