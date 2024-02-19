package com.codigo.msrodriguezesquivel.application.controller;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.PersonaDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestPersona;
import com.codigo.msrodriguezesquivel.domain.ports.in.PersonaServiceIn;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@OpenAPIDefinition(
        info = @Info(
                title = "API-PERSONA",
                version = "1.0",
                description = "Mantenimiento de una Persona"
        )
)
@RestController
@RequestMapping("/v2/persona")
public class PersonaConrtroller {

    @Autowired
    private PersonaServiceIn personaServiceIn;

    @Operation(summary = "Crear una Persona")
    @PostMapping("/crear")
    public ResponseEntity<PersonaDTO> registrar(@RequestBody RequestPersona requestPersona){
        return ResponseEntity.status(HttpStatus.CREATED).body(personaServiceIn.crearPersonaIn(requestPersona));
    }

    @Operation(summary = "Obtener una Persona por id")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<PersonaDTO> obternerPersona(@PathVariable Long id){
        Optional<PersonaDTO> dtoOptional  = personaServiceIn.obtenerPersonaIn(id);
        return dtoOptional.map(dto ->
                        ResponseEntity.status(HttpStatus.OK).body(dto))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Obtener una Persona por DNI")
    @GetMapping("/dni/{dni}")
    public ResponseEntity<PersonaDTO> obtenerXDNI(@PathVariable String dni){
        Optional<PersonaDTO> dtoOptional  = personaServiceIn.obtenerXDNIIn(dni);
        return dtoOptional.map(dto ->
                        ResponseEntity.status(HttpStatus.OK).body(dto))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Obtener una Persona por Estado")
    @GetMapping("/estado")
    public ResponseEntity<List<PersonaDTO>> obtenerXEstado(){
        List<PersonaDTO> personasActivas = personaServiceIn.obtenerXEstadoIn(1);

        if (!personasActivas.isEmpty()) {
            return ResponseEntity.ok(personasActivas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Operation(summary = "Obtener todas las Personas")
    @GetMapping("/listar")
    public ResponseEntity<List<PersonaDTO>> obtenerTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(personaServiceIn.obtenerTodosIn());
    }

    @Operation(summary = "Actualizar una Persona")
    @PutMapping("/guardar/{id}")
    public ResponseEntity<PersonaDTO> actualizar(@PathVariable Long id, @RequestBody RequestPersona requestPersona){
        return ResponseEntity.status(HttpStatus.OK).body(personaServiceIn.actualizarIn(id, requestPersona));
    }

    @Operation(summary = "Eliminar una Persona")
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<PersonaDTO> eliminar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(personaServiceIn.deleteIn(id));
    }


}
