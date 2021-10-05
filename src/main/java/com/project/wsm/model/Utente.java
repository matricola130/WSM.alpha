package com.project.wsm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor @SuperBuilder
@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    @Column(name = "ore_totali")
    private Integer oreTotali;
    @Column(name = "ore_lavorate")
    private Integer oreLavorate;

    @OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
    private List<StoricoOrari> storicoOrari;

    public Utente(String nome, String cognome, String email, String password, Integer ore_totali) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.oreTotali = ore_totali;
    }

    @Override
    public String toString() {
        return "[Utente: " + nome + " " + cognome + " | id: " + id + "]";
    }

}
