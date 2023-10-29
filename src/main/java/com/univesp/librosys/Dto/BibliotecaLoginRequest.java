package com.univesp.librosys.Dto;

import org.springframework.beans.BeanUtils;

import com.univesp.librosys.Model.Biblioteca;

import lombok.Data;

@Data
public class BibliotecaLoginRequest {

    private String email;
    private String senha; 

    public Biblioteca converter(BibliotecaLoginRequest bibliotecaLoginRequest) { 
        Biblioteca biblioteca = new Biblioteca();
        BeanUtils.copyProperties(bibliotecaLoginRequest, biblioteca);
        return biblioteca;
    }
   
}
