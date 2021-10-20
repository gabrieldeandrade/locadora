package br.gov.rj.seplag.sublog.testedev.locadora.service;

import br.gov.rj.seplag.sublog.testedev.locadora.model.Filme;
import br.gov.rj.seplag.sublog.testedev.locadora.model.specification.FilmeSpecification;
import br.gov.rj.seplag.sublog.testedev.locadora.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private FilmeRepository filmeRepository;

    @Autowired
    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> buscar(String nomeFilme, String nomeDiretor, Integer ano) {
        return filmeRepository.findAll(new FilmeSpecification(nomeFilme, nomeDiretor, ano));
    }

}
