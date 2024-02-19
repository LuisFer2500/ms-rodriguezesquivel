package com.codigo.msrodriguezesquivel.domain.ports.out;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.PersonaDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestPersona;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceOut {
    PersonaDTO crearPersonaOut(RequestPersona requestPersona);
    Optional<PersonaDTO> obtenerPersonaOut(Long id);
    Optional<PersonaDTO> obtenerXDNIOut(String dni);
    List<PersonaDTO> obtenerXEstadoOut(int estado);
    List<PersonaDTO> obtenerTodosOut();
    PersonaDTO actualizarOut(Long id, RequestPersona requestPersona);
    PersonaDTO deleteOut(Long id);
}
