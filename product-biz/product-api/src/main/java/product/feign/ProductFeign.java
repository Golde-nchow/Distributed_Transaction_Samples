package product.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import product.entity.Product;

@FeignClient(name = "product-service")
public interface ProductFeign {

    @GetMapping("/product/getById/{id}")
    Product getById(@PathVariable(value = "id") Long id);

    @PostMapping("/product/updateById")
    Product updateById(@RequestBody Product product);

    @PostMapping("/product/save")
    void save(@RequestBody Product product);

}
