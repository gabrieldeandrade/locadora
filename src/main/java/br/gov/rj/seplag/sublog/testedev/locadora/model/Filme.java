package br.gov.rj.seplag.sublog.testedev.locadora.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

// @Entity
public class Filme {

   //  @Id
   //  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer ano;
    private Integer censura;
    private String diretor;

    // @JsonIgnore
    // @OneToMany(mappedBy = "filme", fetch = FetchType.LAZY)
    private List<Fita> fitas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getCensura() {
        return censura;
    }

    public void setCensura(Integer censura) {
        this.censura = censura;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public List<Fita> getFitas() {
        return fitas;
    }

    public void setFitas(List<Fita> fitas) {
        this.fitas = fitas;
    }
}
