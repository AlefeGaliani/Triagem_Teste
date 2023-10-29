package com.univesp.librosys.Dto;

import org.springframework.beans.BeanUtils;

import com.univesp.librosys.Model.Admin;

import lombok.Data;

@Data
public class AdminLoginRequest {

    private String nome;
    private String senha; 

    public Admin converter(AdminLoginRequest adminLoginRequest) { 
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminLoginRequest, admin);
        return admin;
    }
   
}
