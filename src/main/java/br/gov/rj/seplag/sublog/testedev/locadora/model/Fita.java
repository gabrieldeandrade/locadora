package br.gov.rj.seplag.sublog.testedev.locadora.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;


@Entity
public class Fita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serial;

    // @JsonIgnore // Cuidado com as referências circulares!
    @ManyToOne
    private Filme filme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

}
