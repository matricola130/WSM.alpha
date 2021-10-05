package com.project.wsm.repository;

import com.project.wsm.model.StoricoOrari;
import com.project.wsm.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StoricoOrariRepository extends JpaRepository<StoricoOrari, Long> {

    List<StoricoOrari> findAll();

    Optional<StoricoOrari> findStoricoOrariById(Long id);
    Optional<List<StoricoOrari>> findStoricoOrariByDataInizioSettimana(Date dataInizio);
    Optional<List<StoricoOrari>> findStoricoOrariByDataFineSettimana(Date dataFine);
    Optional<List<StoricoOrari>> findStoricoOrariByDataInizioSettimanaAndOreMancanti(Date dataInizio, Integer oreMancanti);

    Optional<List<StoricoOrari>> findStoricoOrariByUtente(Utente utente);
}

