package com.project.wsm.service;

import com.project.wsm.model.Utente;
import com.project.wsm.model.dto.UtenteDTO;

import java.util.List;
import java.util.Optional;

public interface UtenteService {

    public abstract Optional<List<Utente>> getAllUtentiWithOreTotali(Integer oreTotali);
    public abstract List<Utente> getAllUtenti();
    public abstract Utente getUtenteById(Long id);
    public abstract Utente getUtenteByEmail(String email);

    public abstract void deleteAllUtenti();

    public abstract Utente createUtente(UtenteDTO utente);
    public abstract Utente updateUtente(Long id, UtenteDTO utente);
    public abstract void deleteUtente(Long id);

}
