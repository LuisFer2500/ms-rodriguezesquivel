package com.codigo.msrodriguezesquivel.domain.impl;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.PersonaDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestPersona;
import com.codigo.msrodriguezesquivel.domain.ports.in.PersonaServiceIn;
import com.codigo.msrodriguezesquivel.domain.ports.out.PersonaServiceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

@Service
public class PersonaServiceImpl implements PersonaServiceIn {
    @Autowired
    private PersonaServiceOut personaServiceOut;

    @Override
    public PersonaDTO crearPersonaIn(RequestPersona requestPersona) {
        return personaServiceOut.crearPersonaOut(requestPersona);
    }

    @Override
    public Optional<PersonaDTO> obtenerPersonaIn(Long id) {
        return personaServiceOut.obtenerPersonaOut(id);
    }

    @Override
    public Optional<PersonaDTO> obtenerXDNIIn(String dni) {
        return personaServiceOut.obtenerXDNIOut(dni);
    }

    @Override
    public List<PersonaDTO> obtenerXEstadoIn(int estado) {
        return personaServiceOut.obtenerXEstadoOut(estado);
    }

    @Override
    public List<PersonaDTO> obtenerTodosIn() {
        return personaServiceOut.obtenerTodosOut();
    }

    @Override
    public PersonaDTO actualizarIn(Long id, RequestPersona requestPersona) {
        return personaServiceOut.actualizarOut(id, requestPersona);
    }

    @Override
    public PersonaDTO deleteIn(Long id) {
        return personaServiceOut.deleteOut(id);
    }
}
