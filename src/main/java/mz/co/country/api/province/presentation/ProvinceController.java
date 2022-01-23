package mz.co.country.api.province.presentation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mz.co.country.api.country.domain.CountryCommand;
import mz.co.country.api.country.presentation.CountryJson;
import mz.co.country.api.province.domain.ProvinceCommand;
import mz.co.country.api.province.service.ProvinceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "Province Management")
@RequestMapping(path = "/api/v1/provinces", name = "provinces")
@RequiredArgsConstructor
public class ProvinceController {
    private final ProvinceService provinceService;

    @PostMapping
    @ApiOperation("Create a new province")
    public ResponseEntity<ProvinceJson> createProvince(@RequestBody @Valid ProvinceCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(provinceService.create(command));
    }

    @GetMapping("/{id}")
    @ApiOperation("Fetch Province By Id")
    public ResponseEntity<ProvinceJson> getProvinceById(@PathVariable Long id) {
            return ResponseEntity.ok(provinceService.getProvinceById(id));
    }

    @GetMapping
    @ApiOperation("Fetch All provinces")
    public ResponseEntity<Page<ProvinceJson>> getProvinces(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(provinceService.fetchProvinces(pageable));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Province Details")
    public ResponseEntity<ProvinceJson> updateCountry(@PathVariable Long id, @RequestBody @Valid ProvinceCommand command) {
        return  ResponseEntity.ok(provinceService.update(id,command));
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Delete Province")
    public ResponseEntity<?> deleteProvince(@PathVariable Long id) {
            provinceService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
