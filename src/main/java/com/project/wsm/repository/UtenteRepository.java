package com.project.wsm.repository;

import com.project.wsm.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    List<Utente> findAll();

    Optional<Utente> findUtenteById(Long id);
    Optional<Utente> findUtenteByEmail(String email);
    Optional<List<Utente>> findAllByOreTotali(Integer oreTotali);

}
