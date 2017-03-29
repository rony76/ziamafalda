package npe.modello;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ciclisti")
public class Ciclista {
    private Long id;
    private String nome;
    private String cognome;
    private String telefono;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotNull
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @NotNull
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder().append(nome).append(' ').append(cognome).append('(');
        if (id == null)
            buf.append("nuovo");
        else
            buf.append(id);
        return buf.append("), tel '").append(telefono).append('\'').toString();
    }
}
