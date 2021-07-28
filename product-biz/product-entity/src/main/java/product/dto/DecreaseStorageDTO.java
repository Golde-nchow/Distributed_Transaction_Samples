package product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DecreaseStorageDTO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 库存
     */
    private Integer storage;

}
