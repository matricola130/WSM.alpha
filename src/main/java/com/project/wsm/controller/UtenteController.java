package com.project.wsm.controller;

import com.project.wsm.model.Utente;
import com.project.wsm.model.dto.UtenteDTO;
import com.project.wsm.repository.UtenteRepository;
import com.project.wsm.service.UtenteService;
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

    @Autowired
    UtenteService utenteService;

    @GetMapping("/utenti")
    public ResponseEntity<List<Utente>> getAllUtenti(@RequestParam(required = false) Integer oreTotali) {
        List<Utente> listUtenti;

            if(oreTotali == null) {
                listUtenti = utenteService.getAllUtenti();
                if(listUtenti.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                return new ResponseEntity<>(listUtenti, HttpStatus.OK);
            } else {
                return utenteService.getAllUtentiWithOreTotali(oreTotali)
                        .map(utentes -> new ResponseEntity<>(utentes, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
            }
    }

    @GetMapping("utenti/{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(utenteService.getUtenteById(id), HttpStatus.OK);
    }

    @PostMapping("/utenti")
    public ResponseEntity<Utente> createUtente(@RequestBody UtenteDTO utente) {
            return new ResponseEntity<>(utenteService.createUtente(utente), HttpStatus.CREATED);
    }

    @PutMapping("utenti/{id}")
    public ResponseEntity<Utente> updateUtente(@PathVariable("id") Long id, @RequestBody UtenteDTO utente) {

            return new ResponseEntity<>(utenteService.updateUtente(id, utente), HttpStatus.OK);
    }

    @DeleteMapping("utenti")
    public ResponseEntity<HttpStatus> deleteAllUtenti(@RequestParam(required = false) Long id) {
        if(id == null) utenteService.deleteAllUtenti();
            else utenteService.deleteUtente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("utenti/email/{email}")
    public ResponseEntity<Utente> getUtenteByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(utenteService.getUtenteByEmail(email), HttpStatus.OK);
    }

}
