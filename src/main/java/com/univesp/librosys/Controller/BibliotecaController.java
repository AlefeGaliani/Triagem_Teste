package com.univesp.librosys.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univesp.librosys.Dto.BibliotecaLoginRequest;
import com.univesp.librosys.Dto.BibliotecaRequestDto;
import com.univesp.librosys.Model.Biblioteca;
import com.univesp.librosys.Repository.BibliotecaRepository;
import com.univesp.librosys.Service.BibliotecaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/biblioteca")

public class BibliotecaController {
    @Autowired
    private BibliotecaService bibliotecaService;

     @Autowired
    private BibliotecaRepository bibliotecaRepository;


    @PostMapping("/login")    
    public ResponseEntity<?> login(@RequestBody BibliotecaLoginRequest bibliotecaLoginRequest) {
        String email = bibliotecaLoginRequest.getEmail();
        String senha = bibliotecaLoginRequest.getSenha();

        // Busque o biblioteca no banco de dados pelo nome de usuário
        Biblioteca biblioteca = bibliotecaRepository.findByEmail(email);

        if (biblioteca == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não cadastrado");
        }

        // Verifique a senha
        if (senha.equals(biblioteca.getSenha().toString())) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }

        
    }

    @GetMapping("/")
    public List<Biblioteca> buscarTodos(){
       return bibliotecaService.buscarTodos();
    }

    @PostMapping("/")
    public Biblioteca inserir(@RequestBody BibliotecaRequestDto bibliotecaRequestDto){
        return bibliotecaService.inserir(bibliotecaRequestDto);
    }

    @PutMapping("/")
    public Biblioteca alterar(@RequestBody Biblioteca biblioteca){
        return bibliotecaService.alterar(biblioteca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        bibliotecaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
