package products.boot.service;

import product.boot.model.response.ProductModel;
import products.boot.dto.ProductsResponseDto;
import products.boot.entity.ProductsEntity;
import products.boot.repository.ProductsRepository;

public class ProductService {
	
	private final ProductsRepository productsRepository;
	
	public ProductService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	public ProductsResponseDto addProduct(ProductModel model) {
		ProductsEntity entity = new ProductsEntity();
		
		entity.setNome(model.name());
		entity.setPrezzo(model.price());
		entity.setQuantita(model.amount());
		
		ProductsEntity saved = productsRepository.save(entity);
		
		return new ProductsResponseDto(
				saved.getId(),
				saved.getNome(),
				saved.getPrezzo(),
				saved.getQuantita()
				);
				
	}
}
