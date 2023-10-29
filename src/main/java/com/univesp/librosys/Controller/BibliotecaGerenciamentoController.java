package com.univesp.librosys.Controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univesp.librosys.Model.Biblioteca;

import com.univesp.librosys.Service.BibliotecaGerenciamentoService;

@RestController
@RequestMapping("/api/biblioteca-gerenciamento")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BibliotecaGerenciamentoController {

    
    @Autowired
    private BibliotecaGerenciamentoService bibliotecaGerenciamentoService;

    @PostMapping("/senha-codigo")
    public String recuperarCodigo(@RequestBody Biblioteca biblioteca){
       return bibliotecaGerenciamentoService.solicitarCodigo(biblioteca.getEmail());
    }

    @PostMapping("/senha-alterar")
    public String alterarSenha(@RequestBody Biblioteca biblioteca){
       return bibliotecaGerenciamentoService.alterarSenha(biblioteca);
    }

}
