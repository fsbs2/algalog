package com.algaworks.algalog.algalogapi.domain.model;

import com.algaworks.algalog.algalogapi.domain.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Client {
    @NotNull(groups = ValidationGroups.ClientId.class,message = "must not be null")
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can not be blank or null")
    @Size(min = 3, max = 60, message = "Invalid Name: Must be of 3 - 60 characters")
    private String Name;

    @NotBlank
    @Size(max = 255)
    @Email(message = "Invalid e-mail")
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "fone")
    @Pattern(regexp = "^\\d{9}$", message = "Invalid phone number")
    private String telephone;
}

