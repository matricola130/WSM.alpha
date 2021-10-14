package com.project.wsm.model.dto;

import com.project.wsm.model.Utente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.Date;

@Getter @Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class StoricoOrariDTO {

    Integer oreLavorate;
    Integer oreMancanti;
    Date dataInizioSettimana;
    Date dataFineSettimana;
    Utente utente;

}
