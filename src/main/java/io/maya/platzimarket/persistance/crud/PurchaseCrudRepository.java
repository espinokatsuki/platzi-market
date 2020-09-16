package io.maya.platzimarket.persistance.crud;

import io.maya.platzimarket.persistance.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Purchase, Integer> {
    Optional<List<Purchase>> findByIdClient(Integer idClient);
}
