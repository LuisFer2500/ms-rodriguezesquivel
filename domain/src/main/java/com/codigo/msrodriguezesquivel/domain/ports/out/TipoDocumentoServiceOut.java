package com.codigo.msrodriguezesquivel.domain.ports.out;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoDocumentoDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoDocumento;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoServiceOut {
    TipoDocumentoDTO crearTipoDocumentoOut(RequestTipoDocumento requestTipoDocumento);
    Optional<TipoDocumentoDTO> obtenerTipoDocumentoOut(Long id);
    List<TipoDocumentoDTO> obtenerTodosOut();
    TipoDocumentoDTO actualizarOut(Long id, RequestTipoDocumento requestTipoDocumento);
    TipoDocumentoDTO deleteOut(Long id);
}
