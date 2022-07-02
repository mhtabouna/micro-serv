package sun.si.compteservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sun.si.compteservice.entities.Compte;
import sun.si.compteservice.enums.TypeCompte;
import sun.si.compteservice.repositories.CompteRepository;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication   {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }



   @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration){

        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);
            compteRepository.save(new Compte( null,  24425, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte( null,  99828, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte( null,  434, new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach(cp->{
                System.out.println(cp.getType());
                System.out.println(cp.getSolde());

            });
        };
    }


}
