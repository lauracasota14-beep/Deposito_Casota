
package products.boot.command;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import product.boot.model.response.ProductModel;
import products.boot.dto.ProductsResponseDto;
import products.boot.service.ProductService;


@Component
@Scope("prototype")
public class AddProductCommand {

    private final ProductService productsService;
    private ProductModel productModel;

    public AddProductCommand(ProductService productsService) {
        this.productsService = productsService;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public ProductsResponseDto execute() {
        return productsService.addProduct(productModel);
    }
}
