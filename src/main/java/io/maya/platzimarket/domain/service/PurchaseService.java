package io.maya.platzimarket.domain.service;

import io.maya.platzimarket.domain.PurchaseDomain;
import io.maya.platzimarket.domain.repository.PurchaseDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseDomainRepository purchaseDomainRepository;

    public List<PurchaseDomain> getAll() {
        return purchaseDomainRepository.getAll();
    }

    public Optional<List<PurchaseDomain>> getByClientId(Integer clientId) {
        return purchaseDomainRepository.getByClientId(clientId);
    }

    public PurchaseDomain save(PurchaseDomain purchaseDomain) {
        return purchaseDomainRepository.save(purchaseDomain);
    }
}
