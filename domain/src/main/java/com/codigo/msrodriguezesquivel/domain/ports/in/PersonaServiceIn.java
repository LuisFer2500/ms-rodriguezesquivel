package com.codigo.msrodriguezesquivel.domain.ports.in;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.PersonaDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestPersona;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceIn {
    PersonaDTO crearPersonaIn(RequestPersona requestPersona);
    Optional<PersonaDTO> obtenerPersonaIn(Long id);
    Optional<PersonaDTO> obtenerXDNIIn(String dni);
    List<PersonaDTO> obtenerXEstadoIn(int estado);

    List<PersonaDTO> obtenerTodosIn();
    PersonaDTO actualizarIn(Long id, RequestPersona requestPersona);
    PersonaDTO deleteIn(Long id);
}
