package io.maya.platzimarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDomain {
    private int id;
    private String name;
    private boolean active;
}
