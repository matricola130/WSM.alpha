package com.project.wsm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UtenteDTO {

    String nome;
    String cognome;
    String email;
    String password;
    Integer ore_totali;
    Integer ore_lavorate;

}
