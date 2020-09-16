package io.maya.platzimarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDomain {
    private int id;
    private String name;
    private double price;
    private int stock;
    private boolean active;
    private int categoryId;
    private CategoryDomain categoryDomain;
}
