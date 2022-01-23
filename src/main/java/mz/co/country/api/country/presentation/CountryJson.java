package mz.co.country.api.country.presentation;

import lombok.Data;
import mz.co.country.api.province.domain.Province;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
public class CountryJson {
    private Long id;
    private String name;
    private String region;
    private String subRegion;
    private String area;
    private String capital;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
