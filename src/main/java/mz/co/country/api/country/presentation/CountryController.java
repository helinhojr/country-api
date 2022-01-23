package mz.co.country.api.country.presentation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mz.co.country.api.country.domain.CountryCommand;
import mz.co.country.api.country.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "Country Management")
@RequestMapping(path = "/api/v1/countries", name = "countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PostMapping
    @ApiOperation("Create a new country")
    public ResponseEntity<CountryJson> createCountry(@RequestBody @Valid CountryCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.create(command));
    }

    @GetMapping("/{id}")
    @ApiOperation("Fetch Country By Id")
    public ResponseEntity<CountryJson> getCountryById(@PathVariable Long id) {
            return ResponseEntity.ok(countryService.getById(id));
    }

    @GetMapping
    @ApiOperation("Fetch All countries")
    public ResponseEntity<Page<CountryJson>> getCountries(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(countryService.findAll(pageable));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Country Details")
    public ResponseEntity<CountryJson> updateCountry(@PathVariable Long id, @RequestBody @Valid CountryCommand command) {
        return  ResponseEntity.ok(countryService.update(command,id));
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Delete Country")
    public ResponseEntity<?> deleteCountry(@PathVariable Long id) {
            countryService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
