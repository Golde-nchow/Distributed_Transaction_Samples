package orders.controller;

import account.Account;
import account.feign.AccountFeign;
import order.Order;
import orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import product.entity.Product;
import product.feign.ProductFeign;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private AccountFeign accountFeign;

    @Autowired
    private ProductFeign productFeign;

    @Autowired
    private OrderService orderService;

    @GetMapping("/getById/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("/account/getAccountById/{uid}")
    public Account getAccountById(@PathVariable Long uid) {
        return accountFeign.getById(uid);
    }

    @PostMapping("/account/updateById")
    public Account updateAccountById(@RequestBody Account account) {
        return accountFeign.updateById(account);
    }

    @GetMapping("/product/getProductById/{pid}")
    public Product getProductById(@PathVariable Long pid) {
        return productFeign.getById(pid);
    }

    @PostMapping("/product/getProductById")
    public Product updateProductById(@RequestBody Product product) {
        return productFeign.updateById(product);
    }

}
