package mz.co.country.api.country.domain;

import lombok.Data;
import mz.co.country.api.province.domain.Province;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "countries")
@SQLDelete(sql = "UPDATE countries SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String region;
    private String subRegion;
    private String area;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Province province;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
