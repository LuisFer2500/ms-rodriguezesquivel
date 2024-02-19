package com.codigo.msrodriguezesquivel.infraestructure.repository;

import com.codigo.msrodriguezesquivel.infraestructure.entity.TipoPersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TipoPersonaRepository extends JpaRepository<TipoPersonaEntity, Long> {
    TipoPersonaEntity findByCodTipoPersona(@Param("codTipo") String codTipo);
}
