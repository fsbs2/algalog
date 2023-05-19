package com.algaworks.algalog.algalogapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Adresser {
    @Column(name = "adresser_name")
    private String nome;

    @Column(name = "adresser_street")
    private String street;

    @Column(name = "adresser_number")
    private String number;

    @Column(name = "adresser_complement")
    private String complement;

    @Column(name = "adresser_district")
    private String district;
}
