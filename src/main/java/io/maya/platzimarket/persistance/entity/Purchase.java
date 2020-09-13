package io.maya.platzimarket.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private @Column(name = "id_client")
    Integer idClient;
    private LocalDateTime date;
    private @Column(name = "payment_method")
    Character paymentMethod;
    private String comment;
    private Boolean state;
    private @ManyToOne
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    Client client;
    private @OneToMany(mappedBy = "product")
    List<PurchaseProduct> products;
}
