package com.univesp.librosys.Service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.univesp.librosys.Model.Atendimento;
import com.univesp.librosys.Repository.AtendimentoRepository;

@Service
public class AtendimentoService {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public List<Atendimento> buscarTodos() {
        return atendimentoRepository.findAll();
    }

    public Atendimento inserir(Atendimento atendimento) {
        atendimento.setData_registro(new Date());
        Atendimento atendimentoNovo = atendimentoRepository.saveAndFlush(atendimento);
        return atendimentoNovo;
    }

    public Atendimento alterar(Atendimento atendimento) {
        atendimento.setData_atualizacao(new Date());
        return atendimentoRepository.saveAndFlush(atendimento);
    }

    public void excluir(Long id) {
        Atendimento atendimento = atendimentoRepository.findById(id).get();
        atendimentoRepository.delete(atendimento);
    }

}
