package product.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import product.dto.DecreaseStorageDTO;
import product.entity.Product;

@FeignClient(name = "product-service")
public interface ProductFeign {

    @GetMapping("/product/getById/{id}")
    Product getById(@PathVariable(value = "id") Long id);

    @PostMapping("/product/updateById")
    Product updateById(@RequestBody Product product);

    @PostMapping("/product/save")
    void save(@RequestBody Product product);

    @PostMapping("/product/decreaseStorageById")
    void decreaseStorageById(@RequestBody DecreaseStorageDTO decreaseStorageDTO);

}
