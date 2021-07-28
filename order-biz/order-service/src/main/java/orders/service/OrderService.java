package orders.service;

import com.baomidou.mybatisplus.extension.service.IService;
import order.Order;

public interface OrderService extends IService<Order> {

    /**
     * 添加订单信息
     * @param order 信息
     */
    void create(Order order);

}
