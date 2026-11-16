
package products.boot.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import product.boot.model.response.ProductModel;
import products.boot.command.AddProductCommand;
import products.boot.dto.OrderRequestModel;
import products.boot.dto.ProductsResponseDto;
import products.boot.entity.ProductsEntity;
import products.boot.model.request.ProductRequest;
import products.boot.repository.ProductsRepository;

@RestController
@RequestMapping("/store")
public class ProductsController {

    private final ProductsRepository productsRepository;
    private final BeanFactory beanFactory;

    public ProductsController(ProductsRepository productsRepository, BeanFactory beanFactory) {
        this.productsRepository = productsRepository;
        this.beanFactory = beanFactory;
    }

    @GetMapping("/all")
    public List<ProductsResponseDto> getAllProducts() {

        return productsRepository.findAll()
                .stream()
                .map(product -> new ProductsResponseDto(
                        product.getId(),
                        product.getNome(),
                        product.getPrezzo(),
                        product.getQuantita()
                ))
                .toList();
    }

    @PatchMapping("/extract")
    public List<ProductsResponseDto> extractProducts(
            @RequestBody OrderRequestModel request) {

        if (request == null || request.IsIdProducts() == null
                || request.IsIdProducts().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Devi indicare gli ID dei prodotti");
        }

        Map<Long, Integer> quantitaRichieste = new LinkedHashMap<>();

        try {
            String[] ids = request.IsIdProducts().split(";");

            for (String id : ids) {
                Long productId = Long.parseLong(id.trim());
                quantitaRichieste.merge(productId, 1, Integer::sum);
            }
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Formato ID non valido", e);
        }

        List<ProductsResponseDto> response = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : quantitaRichieste.entrySet()) {

            ProductsEntity product = productsRepository
                    .findById(entry.getKey())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Prodotto non trovato: " + entry.getKey()));

            int quantita = entry.getValue();

            if (product.getQuantita() == null
                    || product.getQuantita() < quantita) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Quantita insufficiente per il prodotto "
                                + product.getId());
            }

            response.add(new ProductsResponseDto(
                    product.getId(),
                    product.getNome(),
                    product.getPrezzo(),
                    quantita
            ));
        }

        return response;
    }
    
    
    //una nuova api per inserimento prodotti, questo ogetto contierra 
    //nome prodotto, prezzo unitario e spazio nel magazzino
    //poi a mappare correttamente per poter salvare il database
    
    @PostMapping("/new")
    public ResponseEntity<ProductsResponseDto>addProduct(
    		@RequestBody ProductRequest request){
    	
    	ProductModel model = new ProductModel(
    			request.name(),
    			request.price(),
    			request.amount()
    			);
    	AddProductCommand command = beanFactory.getBean(AddProductCommand.class);
    	command.setProductModel(model);
    	return ResponseEntity.ok(command.execute());
    }
    
    
    
    
    
    
    
    
}
