package npe.modello;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prelievi")
public class Prelievo {
    private Long id;
    private Ciclista ciclista;
    private Date orarioInizio;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "fk_ciclista")
    public Ciclista getCiclista() {
        return ciclista;
    }

    public void setCiclista(Ciclista ciclista) {
        this.ciclista = ciclista;
    }

    public Date getOrarioInizio() {
        return orarioInizio;
    }

    public void setOrarioInizio(Date orarioInizio) {
        this.orarioInizio = orarioInizio;
    }
}
