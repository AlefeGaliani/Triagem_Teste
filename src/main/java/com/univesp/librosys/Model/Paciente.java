package com.univesp.librosys.Model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "paciente")
@Data
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Integer idade;
    private String sexo;
    private String tipo_atendimento;
    private Boolean febre;
    private Boolean dor_cabeca;
    private Boolean dor_muscular;
    private Boolean manchas;
    private Boolean nauseas;
    private Boolean fadiga;
    private Boolean falta_ar;
    private Boolean sangramento;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_registro; 
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_atualizacao; 
}
