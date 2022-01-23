package mz.co.country.api.province.domain;

import lombok.Data;
import mz.co.country.api.country.domain.Country;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "provinces")
@Data
@SQLDelete(sql = "UPDATE provinces SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    @OneToOne(mappedBy = "province")
    private Country country;
}
