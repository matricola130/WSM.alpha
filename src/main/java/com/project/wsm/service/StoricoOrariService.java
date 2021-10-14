package com.project.wsm.service;

import com.project.wsm.model.StoricoOrari;
import com.project.wsm.model.dto.StoricoOrariDTO;

import java.util.List;

public interface StoricoOrariService {

    //CREATE
    StoricoOrari createStoricoOrari(StoricoOrariDTO storicoOrariDTO);

    //FIND
    List<StoricoOrari> getAllStoricoOrari();
    StoricoOrari getStoricoOrariById(Long id);

    //UPDATE
    StoricoOrari updateStoricoOrari(Long id, StoricoOrariDTO storicoOrariDTO);

    //DELETE
    void deleteAllStoricoOrari();

}
