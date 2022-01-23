package mz.co.country.api.country.domain;

import lombok.Data;

@Data
public class CountryCommand {
    private String name;
    private String region;
    private String subRegion;
    private String area;
    private Long provinceId;
}
