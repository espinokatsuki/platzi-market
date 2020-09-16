package io.maya.platzimarket.domain.repository;

import io.maya.platzimarket.domain.PurchaseDomain;

import java.util.List;
import java.util.Optional;

public interface PurchaseDomainRepository {
    List<PurchaseDomain> getAll();

    Optional<List<PurchaseDomain>> getByClientId(Integer clientId);

    PurchaseDomain save(PurchaseDomain purchaseDomain);
}
