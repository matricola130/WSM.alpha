package com.project.wsm.controller;

import com.project.wsm.model.StoricoOrari;
import com.project.wsm.repository.StoricoOrariRepository;
import com.project.wsm.service.StoricoOrariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/storicoOrari")
public class StoricoOrariController {

    @Autowired
    StoricoOrariRepository storicoOrariRepository;

    @Autowired
    StoricoOrariService storicoOrariService;

    public ResponseEntity<List<StoricoOrari>> getAllStoricoOrari() {
        List<StoricoOrari> listOrari;
        return  null;
    }


}
