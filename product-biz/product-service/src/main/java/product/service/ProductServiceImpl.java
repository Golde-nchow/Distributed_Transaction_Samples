package product.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import product.dto.DecreaseStorageDTO;
import product.entity.Product;
import product.mapper.ProductMapper;

import java.util.Objects;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 减少库存
     *
     * @param decreaseStorageDTO 库存信息、商品ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStorageById(DecreaseStorageDTO decreaseStorageDTO) {
        Long id = decreaseStorageDTO.getId();
        Integer storage = decreaseStorageDTO.getStorage();

        Product product = productMapper.selectById(id);
        if (Objects.isNull(product)) {
            throw new RuntimeException("商品信息不存在");
        }

        Integer realStorage = product.getStorage();
        if (realStorage < storage) {
            throw new RuntimeException("库存不足");
        }
        product.setStorage(realStorage - storage);
        productMapper.updateById(product);
    }
}
