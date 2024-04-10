package com.univesp.librosys.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.univesp.librosys.Model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
    
}
