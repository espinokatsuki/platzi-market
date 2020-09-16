package io.maya.platzimarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDomain {
    private int id;
    private int idClient;
    private LocalDateTime date;
    private char paymentMethod;
    private String comments;
    private boolean active;
    private List<PurchaseProductDomain> productDomains;

}
