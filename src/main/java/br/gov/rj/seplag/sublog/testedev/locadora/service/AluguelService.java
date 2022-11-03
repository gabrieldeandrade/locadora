package br.gov.rj.seplag.sublog.testedev.locadora.service;

import br.gov.rj.seplag.sublog.testedev.locadora.model.Aluguel;
import br.gov.rj.seplag.sublog.testedev.locadora.model.Cliente;
import br.gov.rj.seplag.sublog.testedev.locadora.model.Filme;
import br.gov.rj.seplag.sublog.testedev.locadora.model.Fita;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AluguelService {

    public void alugar(List<Fita> fitas, Cliente cliente) {

        List<Aluguel> alugueis = new ArrayList<>();

        for (Fita fita : fitas) {
            if (fita.getFilme().getCensura() > cliente.getIdade()) {
                throw new RuntimeException("Impossível Alugar! - O Filme " + fita.getFilme().getNome() +
                                           " possui a censura maior do que a idade do cliente.");
            }

            Aluguel aluguel = new Aluguel();
            aluguel.setValor(new BigDecimal(10));
            aluguel.setCliente(cliente);
            aluguel.setFita(fita);
            aluguel.setDataInicio(new Date());

            alugueis.add(aluguel);
        }

        persistir(alugueis);

    }

    public void persistir(List<Aluguel> alugueis) {
        for (Aluguel aluguel : alugueis) {
            System.out.println("Alugando fita " + aluguel.getFita().getFilme().getNome());
            persistir(aluguel);
        }
    }

    public void persistir(Aluguel aluguel) {
        // TODO
    }


}