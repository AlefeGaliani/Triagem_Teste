package com.univesp.librosys.Model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "atendimento")
@Data
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPaciente")    
    private Paciente paciente;

    private Integer sala;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_registro; 
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_atualizacao; 
}
