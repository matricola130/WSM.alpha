package com.project.wsm.service;

import com.project.wsm.model.Utente;
import com.project.wsm.model.dto.UtenteDTO;
import com.project.wsm.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    @Override
    public Optional<List<Utente>> getAllUtentiWithOreTotali(Integer oreTotali) {
        return utenteRepository.findAllByOreTotali(oreTotali);
    }

    @Override
    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    @Override
    public Utente getUtenteById(Long id) {
        Optional<Utente> utente = Optional.ofNullable(utenteRepository.findUtenteById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nessun utente trovato con id: " + id)));

        return utente.get();
    }

    @Override
    public Utente getUtenteByEmail(String email) {
        Optional<Utente> utente = Optional.ofNullable(utenteRepository.findUtenteByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Nessun utente trovato con email: " + email)));

        return utente.get();
    }

    @Override
    public void deleteAllUtenti() {
        utenteRepository.deleteAll();
    }

    @Override
    public Utente createUtente(UtenteDTO utente) {
        return utenteRepository
                .save(new Utente(utente.getNome(),
                        utente.getCognome(),
                        utente.getEmail(),
                        utente.getPassword(),
                        utente.getOre_totali()
                ));
    }

    @Override
    public Utente updateUtente(Long id, UtenteDTO utente) {
        Optional<Utente> findUtente = Optional.ofNullable(utenteRepository.findUtenteById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nessun utente da aggiornare con id: " + id)));

        Utente utenteToUpdate = findUtente.get();
        if(!utente.getNome().isEmpty()) utenteToUpdate.setNome(utente.getNome());
        if(!utente.getCognome().isEmpty()) utenteToUpdate.setCognome(utente.getCognome());
        if(!utente.getEmail().isEmpty()) utenteToUpdate.setEmail(utente.getEmail());
        if(!utente.getPassword().isEmpty()) utenteToUpdate.setPassword(utente.getPassword());
        if(utente.getOre_lavorate() != null) utenteToUpdate.setOreLavorate(utente.getOre_lavorate());
        if(utente.getOre_totali() != null) utenteToUpdate.setOreTotali(utente.getOre_totali());

        return utenteRepository.save(utenteToUpdate);
    }

    @Override
    public void deleteUtente(Long id) {
        utenteRepository.deleteById(id);
    }
}
