package product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import product.dto.DecreaseStorageDTO;
import product.entity.Product;

public interface ProductService extends IService<Product> {

    /**
     * 减少库存
     * @param decreaseStorageDTO 库存信息、商品ID
     */
    void decreaseStorageById(DecreaseStorageDTO decreaseStorageDTO);
}
