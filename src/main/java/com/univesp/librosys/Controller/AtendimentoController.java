package com.univesp.librosys.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.univesp.librosys.Model.Atendimento;
import com.univesp.librosys.Service.AtendimentoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/atendimento")

public class AtendimentoController {
     

    @Autowired
    private AtendimentoService adminService;

    @GetMapping("/")
    public List<Atendimento> buscarTodos(){
       return adminService.buscarTodos();
    }

    @PostMapping("/")
    public Atendimento inserir(@RequestBody Atendimento atendimento){
        return adminService.inserir(atendimento);
    }

    @PutMapping("/")
    public Atendimento alterar(@RequestBody Atendimento atendimento){
        return adminService.alterar(atendimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        adminService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
