package com.alderaan.address.street;

import com.alderaan.address.common.constant.Constant;
import com.alderaan.address.postcode.Postcode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Constant.Table.STREET)
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "street_id")
    private Integer id;

    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @OneToOne
    @JoinColumn(name = "postcode_id", nullable = false, updatable = false)
    private Postcode postcode;
}