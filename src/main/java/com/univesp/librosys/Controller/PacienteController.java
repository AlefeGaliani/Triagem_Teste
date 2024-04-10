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
import com.univesp.librosys.Model.Paciente;
import com.univesp.librosys.Service.PacienteService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/paciente")

public class PacienteController {
     

    @Autowired
    private PacienteService adminService;

    @GetMapping("/")
    public List<Paciente> buscarTodos(){
       return adminService.buscarTodos();
    }

    @PostMapping("/")
    public Paciente inserir(@RequestBody Paciente paciente){
        return adminService.inserir(paciente);
    }

    @PutMapping("/")
    public Paciente alterar(@RequestBody Paciente paciente){
        return adminService.alterar(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        adminService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
