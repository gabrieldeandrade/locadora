package br.gov.rj.seplag.sublog.testedev.locadora.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Aluguel {

    private Long id;
    private Date dataInicio;
    private Date dataFim;
    private Date dataHoraEntrega;
    private Boolean rebobinou;
    private BigDecimal valor;
    private Cliente cliente;

    private Fita fita;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(Date dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public Boolean getRebobinou() {
        return rebobinou;
    }

    public void setRebobinou(Boolean rebobinou) {
        this.rebobinou = rebobinou;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fita getFita() {
        return fita;
    }

    public void setFita(Fita fita) {
        this.fita = fita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluguel aluguel = (Aluguel) o;
        return Objects.equals(id, aluguel.id) && Objects.equals(dataInicio, aluguel.dataInicio) && Objects.equals(dataFim, aluguel.dataFim) && Objects.equals(dataHoraEntrega, aluguel.dataHoraEntrega) && Objects.equals(rebobinou, aluguel.rebobinou) && Objects.equals(valor, aluguel.valor) && Objects.equals(cliente, aluguel.cliente) && Objects.equals(fita, aluguel.fita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataInicio, dataFim, dataHoraEntrega, rebobinou, valor, cliente, fita);
    }
}
