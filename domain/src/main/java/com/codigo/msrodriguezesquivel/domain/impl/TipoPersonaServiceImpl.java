package com.codigo.msrodriguezesquivel.domain.impl;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoPersonaDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestPersona;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoPersona;
import com.codigo.msrodriguezesquivel.domain.ports.in.TipoDocumentoServiceIn;
import com.codigo.msrodriguezesquivel.domain.ports.in.TipoPersonaServiceIn;
import com.codigo.msrodriguezesquivel.domain.ports.out.TipoPersonaServiceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPersonaServiceImpl implements TipoPersonaServiceIn {
    @Autowired
    private TipoPersonaServiceOut tipoPersonaServiceOut;
    @Override
    public TipoPersonaDTO crearTipoPersonaIn(RequestTipoPersona requestTipoPersona) {
        return tipoPersonaServiceOut.crearTipoPersonaOut(requestTipoPersona);
    }

    @Override
    public Optional<TipoPersonaDTO> obtenerTipoPersonaIn(Long id) {
        return tipoPersonaServiceOut.obtenerTipoPersonaOut(id);
    }

    @Override
    public List<TipoPersonaDTO> obtenerTodosIn() {
        return tipoPersonaServiceOut.obtenerTodosOut();
    }

    @Override
    public TipoPersonaDTO actualizarIn(Long id, RequestTipoPersona requestTipoPersona) {
        return tipoPersonaServiceOut.actualizarOut(id, requestTipoPersona);
    }

    @Override
    public TipoPersonaDTO deleteIn(Long id) {
        return tipoPersonaServiceOut.deleteOut(id);
    }
}
