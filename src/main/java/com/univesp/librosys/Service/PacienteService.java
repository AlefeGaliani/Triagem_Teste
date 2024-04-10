package com.univesp.librosys.Service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.univesp.librosys.Model.Paciente;
import com.univesp.librosys.Repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente inserir(Paciente paciente) {
        paciente.setData_registro(new Date());
        Paciente pacienteNovo = pacienteRepository.saveAndFlush(paciente);
        return pacienteNovo;
    }

    public Paciente alterar(Paciente paciente) {
        paciente.setData_atualizacao(new Date());
        return pacienteRepository.saveAndFlush(paciente);
    }

    public void excluir(Long id) {
        Paciente paciente = pacienteRepository.findById(id).get();
        pacienteRepository.delete(paciente);
    }

}
