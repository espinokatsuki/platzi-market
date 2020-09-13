package io.maya.platzimarket.persistance.crud;

import io.maya.platzimarket.persistance.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByIdCategoryOrderByNameAsc(int idCategory);

    Optional<List<Product>> findByStockLessThanEqualAndState(Integer stock, Boolean state);
}
