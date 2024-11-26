package com.alderaan.address;

import com.alderaan.address.common.constant.Constant;
import com.alderaan.address.street.Street;
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
@Table(name = Constant.Table.ADDRESS)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;

    @Column(nullable = false, updatable = false)
    private int number;

    @Column(updatable = false)
    private String addition;

    @OneToOne
    @JoinColumn(name = "street_id", nullable = false, updatable = false)
    private Street street;
}