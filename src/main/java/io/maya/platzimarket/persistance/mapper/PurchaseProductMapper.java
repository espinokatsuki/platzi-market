package io.maya.platzimarket.persistance.mapper;

import io.maya.platzimarket.domain.PurchaseProductDomain;
import io.maya.platzimarket.persistance.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseProductMapper {
    @Mappings({
            @Mapping(source = "id.idProduct", target = "id"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "state", target = "active"),
    })
    PurchaseProductDomain toPurchaseProductDomain(PurchaseProduct purchaseProduct);

    List<PurchaseProductDomain> toPurchaseProductDomainList(List<PurchaseProduct> purchaseProducts);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(PurchaseProductDomain purchaseProductDomain);

    List<PurchaseProduct> toPurchaseProducts(List<PurchaseProductDomain> purchaseProductDomains);
}
