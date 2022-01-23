package mz.co.country.api.province.service;

import lombok.RequiredArgsConstructor;
import mz.co.country.api.province.domain.Province;
import mz.co.country.api.province.domain.ProvinceCommand;
import mz.co.country.api.province.domain.ProvinceMapper;
import mz.co.country.api.province.presentation.ProvinceJson;
import mz.co.country.api.province.persistence.ProvinceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceMapper mapper;
    private final ProvinceRepository repository;
    @Override
    public ProvinceJson create(ProvinceCommand command) {
        Province province = mapper.mapToModel(command);
        return mapper.mapToJson(repository.save(province));
    }

    @Override
    public ProvinceJson update(Long provinceId, ProvinceCommand command) {
        Province province = findById(provinceId);
        mapper.updateModel(province,command);
        return mapper.mapToJson(repository.save(province));
    }

    @Override
    public ProvinceJson getProvinceById(Long provinceId) {
        return mapper.mapToJson(findById(provinceId));
    }

    @Override
    public Page<ProvinceJson> fetchProvinces(Pageable pageable) {
        return mapper.mapToJson(repository.findAll(pageable));
    }

    @Override
    public Province findById(Long provinceId) {
        return repository.findById(provinceId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Province not found!"));
    }

    @Override
    public void delete(Long provinceId) {
        Province province = findById(provinceId);
        repository.delete(province);
    }
}
