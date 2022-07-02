package sun.si.compteservice.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name= "p1",types=Compte.class)
public interface Comproj {

    public Long getCode();
    public double getSolde();
}
