package com.project.wsm.controller;

import com.project.wsm.model.StoricoOrari;
import com.project.wsm.model.Utente;
import com.project.wsm.model.dto.StoricoOrariDTO;
import com.project.wsm.repository.StoricoOrariRepository;
import com.project.wsm.service.StoricoOrariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/storicoOrari")
public class StoricoOrariController {

    @Autowired
    StoricoOrariRepository storicoOrariRepository;

    @Autowired
    StoricoOrariService storicoOrariService;

    @GetMapping("/allStoricoOrari")
    public ResponseEntity<List<StoricoOrari>> getAllStoricoOrari() {
        List<StoricoOrari> listStoricoOrari = storicoOrariService.getAllStoricoOrari();

        if(listStoricoOrari.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(listStoricoOrari, HttpStatus.OK);
    }

    @GetMapping("/storicoOrariById")
    public ResponseEntity<StoricoOrari> getStoricoOrariById(@RequestParam("id") Long id) {
        StoricoOrari storicoOrari = storicoOrariService.getStoricoOrariById(id);
        if(storicoOrari == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(storicoOrari, HttpStatus.OK);
        }
    }

    @PostMapping("/new/StoricoOrari")
    public ResponseEntity<StoricoOrari> createStoricoOrari(@RequestBody StoricoOrariDTO storicoOrariDTO){
        StoricoOrari storicoOrari = storicoOrariService.createStoricoOrari(storicoOrariDTO);

        if(storicoOrari != null) {
            return new ResponseEntity<>(storicoOrari, HttpStatus.CREATED);
        } else {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/StoricoOrari/{id}")
    public ResponseEntity<StoricoOrari> updateStoricoOrari(@PathVariable("id") Long id, @RequestBody StoricoOrariDTO storicoOrariDTO){
        StoricoOrari storicoOrari = storicoOrariService.updateStoricoOrari(id ,storicoOrariDTO);

        if(storicoOrari != null) {
            return new ResponseEntity<>(storicoOrari, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
