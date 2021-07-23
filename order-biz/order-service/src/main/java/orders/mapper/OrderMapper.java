package orders.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import order.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper extends BaseMapper<Order> {
}
