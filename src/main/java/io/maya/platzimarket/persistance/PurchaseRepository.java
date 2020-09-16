package io.maya.platzimarket.persistance;

import io.maya.platzimarket.domain.PurchaseDomain;
import io.maya.platzimarket.domain.repository.PurchaseDomainRepository;
import io.maya.platzimarket.persistance.crud.PurchaseCrudRepository;
import io.maya.platzimarket.persistance.entity.Purchase;
import io.maya.platzimarket.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseDomainRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<PurchaseDomain> getAll() {
        return purchaseMapper.toPurchaseDomains((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDomain>> getByClientId(Integer clientId) {
        return purchaseCrudRepository.findByIdClient(clientId).map(purchases -> purchaseMapper.toPurchaseDomains(purchases));
    }

    @Override
    public PurchaseDomain save(PurchaseDomain purchaseDomain) {
        Purchase purchase = purchaseMapper.toPurchase(purchaseDomain);
        purchase.getProducts().forEach(purchaseProduct -> purchaseProduct.setPurchase(purchase));
        return purchaseMapper.toPurchaseDomain(purchaseCrudRepository.save(purchase));
    }
}
