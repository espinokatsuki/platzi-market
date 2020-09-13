package io.maya.platzimarket.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseProductPk implements Serializable {
    private @Column(name = "id_purchase")
    Integer idPurchase;
    private @Column(name = "id_product")
    Integer idProduct;
}
