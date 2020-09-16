package io.maya.platzimarket.persistance.mapper;

import io.maya.platzimarket.domain.PurchaseDomain;
import io.maya.platzimarket.persistance.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseProductMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "idClient", target = "idClient"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comments"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "products", target = "productDomains")
    })
    PurchaseDomain toPurchaseDomain(Purchase purchase);

    List<PurchaseDomain> toPurchaseDomains(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchase(PurchaseDomain purchaseDomain);
}
