package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import product.dto.DecreaseStorageDTO;
import product.entity.Product;
import product.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getById/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping("/updateById")
    public Product updateById(@RequestBody Product product) {
        productService.updateById(product);
        return getById(product.getId());
    }

    /**
     * 减少库存
     * @param decreaseStorageDTO 库存信息、商品ID
     */
    @PostMapping("/decreaseStorageById")
    public void decreaseStorageById(@RequestBody DecreaseStorageDTO decreaseStorageDTO) {
        productService.decreaseStorageById(decreaseStorageDTO);
    }

    @PostMapping("/save")
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

}
