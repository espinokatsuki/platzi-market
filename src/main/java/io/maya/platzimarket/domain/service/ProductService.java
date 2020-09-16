package io.maya.platzimarket.domain.service;

import io.maya.platzimarket.domain.ProductDomain;
import io.maya.platzimarket.domain.repository.ProductDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductDomainRepository productDomainRepository;

    public List<ProductDomain> getAll() {
        return productDomainRepository.getAll();
    }

    public Optional<List<ProductDomain>> getByCategory(Integer id) {
        return productDomainRepository.getByCategory(id);
    }

    public Optional<List<ProductDomain>> getScarceProducts(Integer minStock) {
        return productDomainRepository.getScarceProducts(minStock);
    }

    public Optional<ProductDomain> getProduct(Integer id) {
        return productDomainRepository.getProduct(id);
    }

    public ProductDomain save(ProductDomain productDomain) {
        return productDomainRepository.save(productDomain);
    }

    public boolean delete(Integer id) {
        return getProduct(id).map(productDomain -> {
            productDomainRepository.delete(id);
            return true;
        }).orElse(false);
    }

}
