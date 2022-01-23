package mz.co.country.api.province.domain;

import mz.co.country.api.province.presentation.ProvinceJson;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class ProvinceMapper {
    public static ProvinceMapper INSTANCE = Mappers.getMapper(ProvinceMapper.class);

    @Named("commandToModel")
    public abstract Province mapToModel(ProvinceCommand command);

    public abstract void updateModel(@MappingTarget Province province, ProvinceCommand command);


    public abstract void cloneModel(@MappingTarget Province province, Province provinceSource);

    @InheritInverseConfiguration
    public abstract ProvinceJson mapToJson(Province province);
    public abstract List<ProvinceJson> mapToJson(List<Province> provinces);

    public Page<ProvinceJson> mapToJson(Page<Province> provinces) {
        return new PageImpl<>(mapToJson(provinces.getContent()), provinces.getPageable(), provinces.getTotalElements());
    }
}
