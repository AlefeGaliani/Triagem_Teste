package com.univesp.librosys.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.univesp.librosys.Model.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long>{

    Biblioteca findByEmail(String email);

    Biblioteca findByEmailAndCodigoRecuperacaoSenha(String email, String codigoRecuperacaoSenha);
}