package com.project.wsm.controller;

import com.project.wsm.model.Utente;
import com.project.wsm.model.dto.UtenteDTO;
import com.project.wsm.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    UtenteRepository utenteRepository;

    @GetMapping("/utenti")
    public ResponseEntity<List<Utente>> getAllUtenti(@RequestParam(required = false) Integer oreTotali) {
        List<Utente> listUtenti;

            if(oreTotali == null) {
                listUtenti = utenteRepository.findAll();
                if(listUtenti.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                return new ResponseEntity<>(listUtenti, HttpStatus.OK);

            } else {
                Optional<List<Utente>> optionalUtenteList = utenteRepository.findAllByOreTotali(oreTotali);

                return optionalUtenteList.map(utentes -> new ResponseEntity<>(utentes, HttpStatus.OK))
                                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
            }
    }

    @GetMapping("utenti/{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable("id") Long id) {
        Optional<Utente> utente = Optional.ofNullable(utenteRepository.findUtenteById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nessun utente trovato con id: " + id)));

        return new ResponseEntity<>(utente.get(), HttpStatus.OK);
    }

    @PostMapping("/utenti")
    public ResponseEntity<Utente> createUtente(@RequestBody UtenteDTO utente) {
            Utente utenteToSave = utenteRepository
                    .save(new Utente(utente.getNome(),
                                     utente.getCognome(),
                                     utente.getEmail(),
                                     utente.getPassword(),
                                     utente.getOre_totali()
                    ));
            return new ResponseEntity<>(utenteToSave, HttpStatus.CREATED);
    }

    @PutMapping("utenti/{id}")
    public ResponseEntity<Utente> updateUtente(@PathVariable("id") Long id, @RequestBody UtenteDTO utente) {
        Optional<Utente> findUtente = Optional.ofNullable(utenteRepository.findUtenteById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nessun utente da aggiornare con id: " + id)));

            Utente utenteToUpdate = findUtente.get();
            if(!utente.getNome().isEmpty()) utenteToUpdate.setNome(utente.getNome());
            if(!utente.getCognome().isEmpty()) utenteToUpdate.setCognome(utente.getCognome());
            if(!utente.getEmail().isEmpty()) utenteToUpdate.setEmail(utente.getEmail());
            if(!utente.getPassword().isEmpty()) utenteToUpdate.setPassword(utente.getPassword());
            if(utente.getOre_lavorate() != null) utenteToUpdate.setOreLavorate(utente.getOre_lavorate());
            if(utente.getOre_totali() != null) utenteToUpdate.setOreTotali(utente.getOre_totali());

            return new ResponseEntity<>(utenteRepository.save(utenteToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("utenti")
    public ResponseEntity<HttpStatus> deleteAllUtenti(@RequestParam(required = false) Long id) {
        if(id == null) utenteRepository.deleteAll();
        else utenteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("utenti/email/{email}")
    public ResponseEntity<Utente> getUtenteByEmail(@PathVariable("email") String email) {

        Optional<Utente> utente = Optional.ofNullable(utenteRepository.findUtenteByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Nessun utente trovato con email: " + email)));

        return new ResponseEntity<>(utente.get(), HttpStatus.OK);
    }

}
