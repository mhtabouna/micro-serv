package sun.si.compteservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.si.compteservice.repositories.CompteRepository;
import sun.si.compteservice.entities.Compte;
import javax.transaction.Transactional;

@Service
@Transactional
public class CompteServiceImpl implements compteService{
    @Autowired
    CompteRepository compteRepository;
    @Override
    public void virement(Long codeSource,Long codeDestination, double montant) {

        Compte c1=compteRepository.getById(codeSource);
        Compte c2=compteRepository.getById(codeDestination);

        c1.setSolde(c1.getSolde()-montant);
        c2.setSolde(c2.getSolde()+montant);

        compteRepository.save(c1);
        compteRepository.save(c2);




    }
}
