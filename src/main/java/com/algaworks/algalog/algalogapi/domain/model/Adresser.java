package com.algaworks.algalog.algalogapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Adresser {
    @NotNull(message = "must not be null")
    @Column(name = "adresser_name")
    private String name;

    @NotNull(message = "must not be null")
    @Column(name = "adresser_street")
    private String street;

    @NotNull(message = "must not be null")
    @Column(name = "adresser_number")
    private String number;

    @NotNull(message = "must not be null")
    @Column(name = "adresser_complement")
    private String complement;

    @NotNull(message = "must not be null")
    @Column(name = "adresser_district")
    private String district;
}
