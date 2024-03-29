package com.codigo.msrodriguezesquivel.domain.ports.out;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoPersonaDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestPersona;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoPersona;

import java.util.List;
import java.util.Optional;

public interface TipoPersonaServiceOut {
    TipoPersonaDTO crearTipoPersonaOut(RequestTipoPersona requestTipoPersona);
    Optional<TipoPersonaDTO> obtenerTipoPersonaOut(Long id);
    List<TipoPersonaDTO> obtenerTodosOut();
    TipoPersonaDTO actualizarOut(Long id, RequestTipoPersona requestTipoPersona);
    TipoPersonaDTO deleteOut(Long id);
}
