package com.project.wsm.service;

import com.project.wsm.model.StoricoOrari;

import java.util.List;

public interface StoricoOrariService {

    //CREATE
    StoricoOrari createStoricoOrari();

    //FIND
    List<StoricoOrari> getAllStoricoOrari();
    StoricoOrari getStoricoOrariById();

    //UPDATE
    StoricoOrari updateStoricoOrari();

    //DELETE
    void deleteAllStoricoOrari();

}
