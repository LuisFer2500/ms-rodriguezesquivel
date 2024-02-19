package com.codigo.msrodriguezesquivel.domain.ports.in;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoDocumentoDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoPersonaDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestPersona;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoDocumento;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoPersona;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

public interface TipoPersonaServiceIn {
    TipoPersonaDTO crearTipoPersonaIn(RequestTipoPersona requestTipoPersona);
    Optional<TipoPersonaDTO> obtenerTipoPersonaIn(Long id);
    List<TipoPersonaDTO> obtenerTodosIn();
    TipoPersonaDTO actualizarIn(Long id, RequestTipoPersona requestTipoPersona);
    TipoPersonaDTO deleteIn(Long id);
}
