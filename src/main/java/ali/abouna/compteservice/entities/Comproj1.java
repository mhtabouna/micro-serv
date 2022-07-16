package sun.si.compteservice.entities;


import org.springframework.data.rest.core.config.Projection;
import sun.si.compteservice.enums.TypeCompte;

@Projection(name= "p2",types=Compte.class)
public interface Comproj1 {

     Long getCode();
     TypeCompte getType();
}
