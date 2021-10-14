package com.project.wsm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "storico_orari")
public class StoricoOrari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_storico_orari")
    private Long id;
    @Column(name = "ore_lavorate")
    private Integer oreLavorate;
    @Column(name = "ore_mancanti")
    private Integer oreMancanti;
    @Column(name = "data_inizio_settimana")
    private Date dataInizioSettimana;
    @Column(name = "data_fine_settimana")
    private Date dataFineSettimana;
    @Column(name = "data_ultimo_aggiornamento")
    private Date ultimoAggiornamento;

    //Relazione Utente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utente")
    private Utente utente;

    public StoricoOrari(Integer oreLavorate, Integer oreMancanti, Date dataInizioSettimana, Date dataFineSettimana, Date ultimoAggiornamento, Utente utente) {
        this.oreLavorate = oreLavorate;
        this.oreMancanti = oreMancanti;
        this.dataInizioSettimana = dataInizioSettimana;
        this.dataFineSettimana = dataFineSettimana;
        this.ultimoAggiornamento = ultimoAggiornamento;
        this.utente = utente;
    }
}
