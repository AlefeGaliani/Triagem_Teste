package com.univesp.librosys.Service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.librosys.Dto.BibliotecaRequestDto;
import com.univesp.librosys.Model.Biblioteca;
import com.univesp.librosys.Repository.BibliotecaRepository;


@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;


    public List<Biblioteca> buscarTodos() {
        return bibliotecaRepository.findAll();
    }
//
    public Biblioteca inserir(BibliotecaRequestDto bibliotecaRequestDto) {
        Biblioteca biblioteca = new BibliotecaRequestDto().converter(bibliotecaRequestDto);
        biblioteca.setData_registro(new Date());
        Biblioteca bibliotecaNovo = bibliotecaRepository.saveAndFlush(biblioteca);
        return bibliotecaNovo;
    }

    public Biblioteca alterar(Biblioteca biblioteca) {
        biblioteca.setData_atualizacao(new Date());
        return bibliotecaRepository.saveAndFlush(biblioteca);
    }

    public void excluir(Long id) {
        Biblioteca biblioteca = bibliotecaRepository.findById(id).get();
        bibliotecaRepository.delete(biblioteca);
    }

}

