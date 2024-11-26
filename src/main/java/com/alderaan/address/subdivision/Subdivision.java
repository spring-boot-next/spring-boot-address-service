package com.alderaan.address.subdivision;

import com.alderaan.address.common.constant.Constant;
import com.alderaan.address.country.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Subdivision codes are saved as per the ISO 3166-2 standard.
 *
 * @since 2024-11-25
 * @author Jeffrey Spaan
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Constant.Table.SUBDIVISION)
public class Subdivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subdivision_id")
    private Integer id;

    @Column(unique = true, length = 5)
    private String iso;

    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private SubdivisionType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}