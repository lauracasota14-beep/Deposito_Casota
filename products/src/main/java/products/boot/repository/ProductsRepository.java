
package products.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import products.boot.entity.ProductsEntity;

@Repository
public interface ProductsRepository
        extends JpaRepository<ProductsEntity, Long> {

}
