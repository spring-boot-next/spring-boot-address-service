package com.alderaan.address.country;

import com.alderaan.address.common.constant.Constant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Country codes are saved as per the ISO 3166 Alpha-2 standard
 * The country codes are represented as a two-letter code (alpha-2)
 * which is recommended as the general-purpose code.
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
@Table(name = Constant.Table.COUNTRY)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer id;

    @Column(unique = true, length = 2)
    private String iso;

    @Column(unique = true, nullable = false, length = 100)
    private String name;
}