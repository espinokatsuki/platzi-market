package io.maya.platzimarket.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String name;
    private @Column(name = "id_category")
    Integer idCategory;
    private @Column(name = "bar_code")
    String barCode;
    private Double price;
    private Integer stock;
    private Boolean state;
    private @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    Category category;
}
