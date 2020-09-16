package io.maya.platzimarket.web.controller;

import io.maya.platzimarket.domain.PurchaseDomain;
import io.maya.platzimarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<PurchaseDomain>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<List<PurchaseDomain>> getByClientId(@PathVariable("clientId") Integer clientId) {
        return purchaseService.getByClientId(clientId)
                .map(purchaseDomains -> new ResponseEntity<>(purchaseDomains, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PurchaseDomain> save(@RequestBody PurchaseDomain purchaseDomain) {
        return new ResponseEntity<>(purchaseService.save(purchaseDomain), HttpStatus.OK);
    }
}
