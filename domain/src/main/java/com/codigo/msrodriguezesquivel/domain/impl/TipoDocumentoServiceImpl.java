package com.codigo.msrodriguezesquivel.domain.impl;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoDocumentoDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoDocumento;
import com.codigo.msrodriguezesquivel.domain.ports.in.TipoDocumentoServiceIn;
import com.codigo.msrodriguezesquivel.domain.ports.out.TipoDocumentoServiceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoServiceIn {
    @Autowired
    private TipoDocumentoServiceOut tipoDocumentoServiceOut;
    @Override
    public TipoDocumentoDTO crearTipoDocumentoIn(RequestTipoDocumento requestTipoDocumento) {
        return tipoDocumentoServiceOut.crearTipoDocumentoOut(requestTipoDocumento);
    }

    @Override
    public Optional<TipoDocumentoDTO> obtenerTipoDocumentoIn(Long id) {
        return tipoDocumentoServiceOut.obtenerTipoDocumentoOut(id);
    }

    @Override
    public List<TipoDocumentoDTO> obtenerTodosIn() {
        return tipoDocumentoServiceOut.obtenerTodosOut();
    }

    @Override
    public TipoDocumentoDTO actualizarIn(Long id, RequestTipoDocumento requestTipoDocumento) {
        return tipoDocumentoServiceOut.actualizarOut(id, requestTipoDocumento);
    }

    @Override
    public TipoDocumentoDTO deleteIn(Long id) {
        return tipoDocumentoServiceOut.deleteOut(id);
    }
}
