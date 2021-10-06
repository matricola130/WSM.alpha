package com.project.wsm;

import com.project.wsm.model.Utente;
import com.project.wsm.repository.UtenteRepository;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class loadDatabase {

    private static final Logger log = LoggerFactory.logger(loadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UtenteRepository utenteRepository) {
        return args -> {
            log.info("Preloading: " + utenteRepository.save(new Utente("Bilbo","Baggins","bbadventure@contea.org","ilmiotessoro",100)));
            log.info("Preloading: " + utenteRepository.save(new Utente("Paolo","Bitta","paolopooh147@email.ebbasta","chifermeràlamusica",5)));
        };
    }

}
