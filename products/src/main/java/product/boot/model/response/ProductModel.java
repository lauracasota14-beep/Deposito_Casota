package product.boot.model.response;

import java.math.BigDecimal;

public record ProductModel(String name, BigDecimal price, Integer amount) {

}
