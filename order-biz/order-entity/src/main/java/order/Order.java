package order;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("c_order")
public class Order {

    /**
     * 主键
     */
    private Long id;

    /**
     * 商品id
     */
    private Long pid;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 余额
     */
    private BigDecimal amount;

    /**
     * 购买数量
     */
    private Integer buyCount;

    /**
     * 是否删除
     */
    private Boolean deleted;
}
