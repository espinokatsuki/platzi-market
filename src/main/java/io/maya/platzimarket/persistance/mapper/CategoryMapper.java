package io.maya.platzimarket.persistance.mapper;

import io.maya.platzimarket.domain.CategoryDomain;
import io.maya.platzimarket.persistance.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "description", target = "name"),
            @Mapping(source = "state", target = "active")
    })
    Category toCategory(CategoryDomain categoryDomain);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryDomain toCategoryDomain(Category category);
}
