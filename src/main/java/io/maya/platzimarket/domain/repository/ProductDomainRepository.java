package io.maya.platzimarket.domain.repository;

import io.maya.platzimarket.domain.ProductDomain;

import java.util.List;
import java.util.Optional;

public interface ProductDomainRepository {
    List<ProductDomain> getAll();

    Optional<List<ProductDomain>> getByCategory(Integer id);

    Optional<List<ProductDomain>> getScarceProducts(Integer minStock);

    Optional<ProductDomain> getProduct(Integer id);

    ProductDomain save(ProductDomain productDomain);

    void delete(Integer id);
}
