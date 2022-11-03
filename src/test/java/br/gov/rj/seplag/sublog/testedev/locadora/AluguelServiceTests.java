package br.gov.rj.seplag.sublog.testedev.locadora;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import br.gov.rj.seplag.sublog.testedev.locadora.model.Aluguel;
import br.gov.rj.seplag.sublog.testedev.locadora.model.Cliente;
import br.gov.rj.seplag.sublog.testedev.locadora.model.Filme;
import br.gov.rj.seplag.sublog.testedev.locadora.model.Fita;
import br.gov.rj.seplag.sublog.testedev.locadora.service.AluguelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AluguelServiceTests {

    @Spy
    @InjectMocks
    AluguelService aluguelService;

    @Captor
    private ArgumentCaptor<Cliente> clienteArgumentCaptor;

    @Captor
    private ArgumentCaptor<Aluguel> aluguelArgumentCaptor;

    @Test
    public void alugar_sucesso() {
        List<Fita> listaFitas = criarListaDeFitas();

        Cliente cliente = criarCliente();

        aluguelService.alugar(listaFitas, cliente);

        verify(aluguelService, times(listaFitas.size())).persistir(aluguelArgumentCaptor.capture());

        for (Aluguel a : aluguelArgumentCaptor.getAllValues()) {

            System.out.println("Testando aluguel do filme " + a.getFita().getFilme().getNome());

            assertEquals(a.getValor(), new BigDecimal(10));
            assertEquals(a.getCliente(), cliente);
            assertTrue(listaFitas.contains(a.getFita()));
            assertTrue(a.getDataInicio().getTime() < new Date().getTime());
        }

    }

    @Test()
    public void alugar_erro_censura() {
        List<Fita> listaFitas = criarListaDeFitas();
        Cliente cliente = criarCliente();
        listaFitas.get(2).getFilme().setCensura(99);
        assertThrows(RuntimeException.class, () -> aluguelService.alugar(listaFitas, cliente));
        verify(aluguelService, never()).persistir(any(Aluguel.class));
    }


    private List<Fita> criarListaDeFitas() {
        List<Fita> fitas = new ArrayList<>();

        Filme filme = new Filme();
        Fita fita = new Fita();

        filme.setId(1L);
        filme.setCensura(1);
        filme.setNome("E.T o Extraterrestre");
        filme.setAno(1982);
        filme.setDiretor("Steven Spielberg");
        fita.setFilme(filme);
        fita.setId(1L);
        fita.setSerial("123");
        fitas.add(fita);


        filme = new Filme();
        fita = new Fita();

        filme.setId(2L);
        filme.setCensura(1);
        filme.setNome("De Volta para o Futuro");
        filme.setAno(1985);
        filme.setDiretor("Robert Zemeckis");
        fita.setFilme(filme);
        fita.setId(2L);
        fita.setSerial("345");
        fitas.add(fita);

        filme = new Filme();
        fita = new Fita();

        filme.setId(3L);
        filme.setCensura(0);
        filme.setNome("O Demolidor");
        filme.setAno(1993);
        filme.setDiretor("Marco Brambilla");
        fita.setFilme(filme);
        fita.setId(3L);
        fita.setSerial("567");
        fitas.add(fita);

        return fitas;
    }

    private Cliente criarCliente() {
        Cliente cliente = new Cliente();
        cliente.setGenero("Fluido");
        cliente.setId(1L);
        cliente.setNome("Wheylerrson da Silva");
        cliente.setNumeroCliente("123");
        cliente.setIdade(18);
        return cliente;
    }

}

