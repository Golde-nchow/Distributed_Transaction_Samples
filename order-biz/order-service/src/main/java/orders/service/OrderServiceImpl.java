package orders.service;

import account.dto.DecreaseAmountDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import order.Order;
import order.feign.AccountFeign;
import order.feign.ProductFeign;
import orders.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.dto.DecreaseStorageDTO;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private AccountFeign accountFeign;

    @Autowired
    private ProductFeign productFeign;

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 添加订单信息
     * @param order 信息
     */
    @Override
    @GlobalTransactional
    public void create(Order order) {
        // 添加订单信息
        orderMapper.insert(order);

        // 减少商品库存
        productFeign.decreaseStorageById(DecreaseStorageDTO.builder()
                .id(order.getPid())
                .storage(order.getBuyCount())
                .build()
        );

        // 减少用户余额
        accountFeign.decreaseAmountById(DecreaseAmountDTO.builder()
                .id(order.getUid())
                .amount(order.getAmount())
                .build()
        );
    }
}
