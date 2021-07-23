package orders.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import order.Order;
import orders.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
