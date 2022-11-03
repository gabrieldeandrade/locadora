package br.gov.rj.seplag.sublog.testedev.locadora.controller;

import br.gov.rj.seplag.sublog.testedev.locadora.model.Filme;
//import br.gov.rj.seplag.sublog.testedev.locadora.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1")
public class FilmeController {

    // private final FilmeService filmeService;

    // @Autowired
    // public FilmeController(FilmeService filmeService) {
    //     this.filmeService = filmeService;
    // }

    @RequestMapping(method = RequestMethod.GET, path = "/filmes")
    public List<Filme> listar(@RequestParam(required = false) String nomeFilme,
                                   @RequestParam(required = false) String nomeDiretor,
                                   @RequestParam(required = false) Integer ano){

        return null;

        // return this.filmeService.buscar(nomeFilme, nomeDiretor, ano);
    }

}
