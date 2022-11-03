package br.gov.rj.seplag.sublog.testedev.locadora.model;

import java.util.Date;
import java.util.Objects;

public class Cliente {

    private Long id;
    private String numeroCliente;
    private String nome;
    private Integer idade;
    private String genero;
    private Date dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(numeroCliente, cliente.numeroCliente) && Objects.equals(nome, cliente.nome) && Objects.equals(idade, cliente.idade) && Objects.equals(genero, cliente.genero) && Objects.equals(dataCadastro, cliente.dataCadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroCliente, nome, idade, genero, dataCadastro);
    }
}
