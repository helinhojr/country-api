package mz.co.country.api.country.service;

import mz.co.country.api.country.domain.Country;
import mz.co.country.api.country.domain.CountryCommand;
import mz.co.country.api.country.presentation.CountryJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {
    Page<CountryJson> findAll(Pageable pageable);
    CountryJson create(CountryCommand command);
    CountryJson update(CountryCommand command, Long countryId);
    Country findById(Long countryId);
    void deleteById(Long countryId);
    CountryJson getById(Long countryId);
}
