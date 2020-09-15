package io.maya.platzimarket.persistance;

import io.maya.platzimarket.domain.ProductDomain;
import io.maya.platzimarket.domain.repository.ProductDomainRepository;
import io.maya.platzimarket.persistance.crud.ProductCrudRepository;
import io.maya.platzimarket.persistance.entity.Product;
import io.maya.platzimarket.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductDomainRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDomain> getAll() {
        List<Product> productList = (List<Product>) productCrudRepository.findAll();
        return productMapper.toProductsDomain(productList);
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory(Integer id) {
        List<Product> productList = productCrudRepository.findByIdCategoryOrderByNameAsc(id);
        return Optional.of(productMapper.toProductsDomain(productList));
    }

    @Override
    public Optional<List<ProductDomain>> getScarceProducts(Integer minStock) {
        Optional<List<Product>> productList = productCrudRepository.findByStockLessThanEqual(minStock);
        return productList.map(products -> productMapper.toProductsDomain(products));
    }

    @Override
    public Optional<ProductDomain> getProduct(Integer id) {
        Optional<Product> product = productCrudRepository.findById(id);
        return product.map(product1 -> productMapper.toProductDomain(product1));
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        Product product = productMapper.toProduct(productDomain);
        return productMapper.toProductDomain(productCrudRepository.save(product));
    }

    @Override
    public void delete(Integer id) {
        productCrudRepository.deleteById(id);
    }
}
