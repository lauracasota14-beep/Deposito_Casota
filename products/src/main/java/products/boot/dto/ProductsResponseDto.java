
package products.boot.dto;

import java.math.BigDecimal;

public record ProductsResponseDto(
        Long id,
        String name,
        BigDecimal price,
        Integer amount
) {

}
