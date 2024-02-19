package com.codigo.msrodriguezesquivel.domain.ports.in;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoDocumentoDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoDocumento;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoServiceIn {
    TipoDocumentoDTO crearTipoDocumentoIn(RequestTipoDocumento requestTipoDocumento);
    Optional<TipoDocumentoDTO> obtenerTipoDocumentoIn(Long id);
    List<TipoDocumentoDTO> obtenerTodosIn();
    TipoDocumentoDTO actualizarIn(Long id, RequestTipoDocumento requestTipoDocumento);
    TipoDocumentoDTO deleteIn(Long id);
}
