package sun.si.compteservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import sun.si.compteservice.entities.Compte;
import sun.si.compteservice.enums.TypeCompte;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
    @RestResource(path = "/byType")
    List<Compte> findByType(@Param(value = "type") TypeCompte TypeCompte);
}


