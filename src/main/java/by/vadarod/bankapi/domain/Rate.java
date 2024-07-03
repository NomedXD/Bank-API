package by.vadarod.bankapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "rates")
@Getter
@Setter
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "current_id", nullable = false)
    private Long currentId;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "current_abbreviation", nullable = false)
    private String currentAbbreviation;

    @Column(name = "current_scale", nullable = false)
    private Long currentScale;

    @Column(name = "current_name", nullable = false)
    private String currentName;

    @Column(name = "current_official_rate", nullable = false)
    private Double currentOfficialRate;
}
