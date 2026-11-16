package products.boot.model.request;

import java.math.BigDecimal;

public record ProductRequest(String name, BigDecimal price,Integer amount) {

}
