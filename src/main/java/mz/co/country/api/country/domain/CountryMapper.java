package mz.co.country.api.country.domain;

import mz.co.country.api.country.presentation.CountryJson;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class CountryMapper {
    public static CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Named("commandToModel")
    public abstract Country mapToModel(CountryCommand command);


    public abstract void updateModel(@MappingTarget Country country, CountryCommand command);


    public abstract void cloneModel(@MappingTarget Country country, Country countrySource);

    @InheritInverseConfiguration
    @Mapping(source = "province.name",target = "capital")
    public abstract CountryJson mapToJson(Country country);
    public abstract List<CountryJson> mapToJson(List<Country> countries);

    public Page<CountryJson> mapToJson(Page<Country> countries) {
        return new PageImpl<>(mapToJson(countries.getContent()), countries.getPageable(), countries.getTotalElements());
    }
}
