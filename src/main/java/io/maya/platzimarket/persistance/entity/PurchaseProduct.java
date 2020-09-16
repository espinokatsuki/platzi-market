package io.maya.platzimarket.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "purchase_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseProduct {
    private @EmbeddedId
    PurchaseProductPk id;
    private Integer quantity;
    private Double total;
    private Boolean state;
    private @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
    Purchase purchase;
    private @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    Product product;
}
