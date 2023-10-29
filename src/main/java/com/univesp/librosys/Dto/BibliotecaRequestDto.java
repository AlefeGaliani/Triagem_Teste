package com.univesp.librosys.Dto;

import org.springframework.beans.BeanUtils;

import com.univesp.librosys.Model.Biblioteca;

import lombok.Data;


@Data
public class BibliotecaRequestDto {
    
    private String nome;
    private String email;

    public Biblioteca converter(BibliotecaRequestDto bibliotecaRequestDto) { 
        Biblioteca biblioteca = new Biblioteca();
        BeanUtils.copyProperties(bibliotecaRequestDto, biblioteca);
        return biblioteca;
    }    
}