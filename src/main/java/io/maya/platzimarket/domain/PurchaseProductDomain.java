package io.maya.platzimarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseProductDomain {
    private int id;
    private int quantity;
    private double total;
    private boolean active;
}
