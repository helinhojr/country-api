package mz.co.country.api.province.service;

import mz.co.country.api.province.domain.Province;
import mz.co.country.api.province.domain.ProvinceCommand;
import mz.co.country.api.province.presentation.ProvinceJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProvinceService {
   ProvinceJson create(ProvinceCommand command);
   ProvinceJson update(Long provinceId, ProvinceCommand command);
   ProvinceJson getProvinceById(Long provinceId);
   Page<ProvinceJson> fetchProvinces(Pageable pageable);
   Province findById(Long provinceId);
   void delete(Long provinceId);
}
