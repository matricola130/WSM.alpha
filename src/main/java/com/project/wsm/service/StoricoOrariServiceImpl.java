package com.project.wsm.service;

import com.project.wsm.model.StoricoOrari;
import com.project.wsm.model.dto.StoricoOrariDTO;
import com.project.wsm.repository.StoricoOrariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StoricoOrariServiceImpl implements StoricoOrariService {

    @Autowired
    StoricoOrariRepository storicoOrariRepository;

    @Override
    public StoricoOrari createStoricoOrari(StoricoOrariDTO storicoOrariDTO) {
        return storicoOrariRepository
                .save(new StoricoOrari(
                        storicoOrariDTO.getOreLavorate(),
                        storicoOrariDTO.getOreMancanti(),
                        storicoOrariDTO.getDataInizioSettimana(),
                        storicoOrariDTO.getDataFineSettimana(),
                        new Date(),
                        storicoOrariDTO.getUtente()
                ));
    }

    @Override
    public List<StoricoOrari> getAllStoricoOrari() {
        return storicoOrariRepository.findAll();
    }

    @Override
    public StoricoOrari getStoricoOrariById(Long id) {
        return storicoOrariRepository.findStoricoOrariById(id).orElse(null);
    }

    @Override
    public StoricoOrari updateStoricoOrari(Long id, StoricoOrariDTO storicoOrariDTO) {
        Optional<StoricoOrari> toUpdateStoricoOrariOptional = Optional.ofNullable(storicoOrariRepository.findStoricoOrariById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nessun Storico Orari da aggiornare con id: " + id)));

        StoricoOrari toUpdateStoricoOrari = toUpdateStoricoOrariOptional.get();
        if(storicoOrariDTO.getOreLavorate() != null) toUpdateStoricoOrari.setOreLavorate(storicoOrariDTO.getOreLavorate());
        if(storicoOrariDTO.getOreMancanti() != null) toUpdateStoricoOrari.setOreMancanti(storicoOrariDTO.getOreMancanti());
        if(storicoOrariDTO.getDataInizioSettimana() != null) toUpdateStoricoOrari.setDataInizioSettimana(storicoOrariDTO.getDataInizioSettimana());
        if(storicoOrariDTO.getDataFineSettimana() != null) toUpdateStoricoOrari.setDataFineSettimana(storicoOrariDTO.getDataFineSettimana());
        if(storicoOrariDTO.getUtente() != null) toUpdateStoricoOrari.setUtente(storicoOrariDTO.getUtente());
        toUpdateStoricoOrari.setUltimoAggiornamento(new Date());

        return storicoOrariRepository.save(toUpdateStoricoOrari);
    }

    @Override
    public void deleteAllStoricoOrari() {
        storicoOrariRepository.deleteAll();
    }
}
