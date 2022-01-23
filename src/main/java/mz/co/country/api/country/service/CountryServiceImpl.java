package mz.co.country.api.country.service;

import lombok.RequiredArgsConstructor;
import mz.co.country.api.country.domain.Country;
import mz.co.country.api.country.domain.CountryCommand;
import mz.co.country.api.country.domain.CountryMapper;
import mz.co.country.api.country.persistence.CountryRepository;
import mz.co.country.api.country.presentation.CountryJson;
import mz.co.country.api.province.domain.Province;
import mz.co.country.api.province.service.ProvinceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;
    private final ProvinceService provinceService;
    private final CountryMapper MAPPER = CountryMapper.INSTANCE;

    @Override
    public CountryJson create(CountryCommand command) {
        Country country = MAPPER.mapToModel(command);
        Province province = provinceService.findById(command.getProvinceId());
        country.setProvince(province);
        return MAPPER.mapToJson(repository.save(country));
    }

    @Override
    public CountryJson update(CountryCommand command, Long id) {
        Country country = findById(id);
        MAPPER.updateModel(country, command);
        Province province = provinceService.findById(command.getProvinceId());
        country.setProvince(province);
        return MAPPER.mapToJson(repository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public CountryJson getById(Long id) {
        return MAPPER.mapToJson(findById(id));
    }

    @Override
    public Page<CountryJson> findAll(Pageable pageable) {
        return MAPPER.mapToJson(repository.findAll(pageable));
    }

    @Override
    public Country findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Country not found"));
    }
}
