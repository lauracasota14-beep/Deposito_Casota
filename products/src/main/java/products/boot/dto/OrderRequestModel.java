
package products.boot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRequestModel(
        @JsonProperty("IsIdProducts") String IsIdProducts
) {

}
