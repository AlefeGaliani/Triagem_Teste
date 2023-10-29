package com.univesp.librosys.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.univesp.librosys.Model.Biblioteca;
import com.univesp.librosys.Repository.BibliotecaRepository;



@Service
public class BibliotecaGerenciamentoService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private EmailService emailService;

    /* 
    @Autowired
    PasswordEncoder passwordEncoder;
    */

    public String solicitarCodigo(String email) {
        Biblioteca biblioteca = bibliotecaRepository.findByEmail(email);
        biblioteca.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(biblioteca.getId()));
        biblioteca.setDataEnvioCodigo(new Date());
        bibliotecaRepository.saveAndFlush(biblioteca);
        Map<String, Object> proprMap = new HashMap<>();
        proprMap.put("nome", biblioteca.getNome());
        proprMap.put("mensagem", "Seu cadastro foi efetuado com sucesso, use este código para registrar sua senha de usuário Bilbio Manager: " + biblioteca.getCodigoRecuperacaoSenha());
        emailService.enviarEmailTemplate(biblioteca.getEmail(), "Cadastro de usuário Biblio Manager", proprMap);
        /*emailService.enviarEmailTexto(biblioteca.getEmail(), "Código de Cadastro de Senha Usuário Biblio Manager",
                "Olá, seu cadastro foi efetuado com sucesso, use este código para registrar sua senha de usuário Bilbio Manager: " + biblioteca.getCodigoRecuperacaoSenha());
        */
        return "Código Enviado!";
    }

    public String alterarSenha(Biblioteca biblioteca) {

        Biblioteca bibliotecaBanco = bibliotecaRepository.findByEmailAndCodigoRecuperacaoSenha(biblioteca.getEmail(),
                biblioteca.getCodigoRecuperacaoSenha());
        if (bibliotecaBanco != null) {
            Date diferenca = new Date(new Date().getTime() - bibliotecaBanco.getDataEnvioCodigo().getTime());
            if (diferenca.getTime() / 1000 < 900) {
                //RETORNAR COM PASSENCODER DEPOIS
                //bibliotecaBanco.setSenha(passwordEncoder.encode(biblioteca.getSenha()));
                bibliotecaBanco.setSenha(biblioteca.getSenha());
                bibliotecaBanco.setCodigoRecuperacaoSenha(null);
                bibliotecaRepository.saveAndFlush(bibliotecaBanco);
                return "Senha alterada com sucesso!";
            } else {
                return "Tempo expirado, solicite um novo código";
            }
        } else {
            return "Email ou código não encontrado!";
        }
    }

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
    }


}