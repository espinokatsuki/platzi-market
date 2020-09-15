package io.maya.platzimarket.persistance.mapper;

import io.maya.platzimarket.domain.ProductDomain;
import io.maya.platzimarket.persistance.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category"),
            @Mapping(source = "categoryId", target = "idCategory")
    })
    Product toProduct(ProductDomain productDomain);

    List<Product> toProducts(List<ProductDomain> productDomains);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    ProductDomain toProductDomain(Product product);

    List<ProductDomain> toProductsDomain(List<Product> product);
}
