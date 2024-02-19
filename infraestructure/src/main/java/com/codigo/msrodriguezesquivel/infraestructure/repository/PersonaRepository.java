package com.codigo.msrodriguezesquivel.infraestructure.repository;

import com.codigo.msrodriguezesquivel.infraestructure.entity.PersonaEntity;
import com.codigo.msrodriguezesquivel.infraestructure.entity.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
    PersonaEntity findByNumDocu(@Param("numDocu")String numDocu);
    List<PersonaEntity> findByEstado(@Param("estado")int estado);
}
