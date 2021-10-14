package com.project.wsm.service;

import com.project.wsm.model.Utente;
import com.project.wsm.model.dto.UtenteDTO;

import java.util.List;
import java.util.Optional;

public interface UtenteService {

    //CREATE
    Utente createUtente(UtenteDTO utente);

    //FIND
    Optional<List<Utente>> getAllUtentiWithOreTotali(Integer oreTotali);
    List<Utente> getAllUtenti();
    Utente getUtenteById(Long id);
    Utente getUtenteByEmail(String email);

    //UPDATE
    Utente updateUtente(Long id, UtenteDTO utente);

    //DELETE
    void deleteAllUtenti();
    void deleteUtente(Long id);

}
