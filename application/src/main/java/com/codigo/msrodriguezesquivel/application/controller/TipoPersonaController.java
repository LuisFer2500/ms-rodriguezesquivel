package com.codigo.msrodriguezesquivel.application.controller;


import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoPersonaDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoPersona;
import com.codigo.msrodriguezesquivel.domain.ports.in.TipoPersonaServiceIn;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "API-TIPO PERSONA",
                version = "1.0",
                description = "Mantenimiento de Tipo Persona"
        )
)
@RestController
@RequestMapping("/v2/tipoPersona")
public class TipoPersonaController {
    @Autowired
    private TipoPersonaServiceIn tipoPersonaServiceIn;

    @Operation(summary = "Crear un Tipo Persona")
    @PostMapping("/crear")
    public ResponseEntity<TipoPersonaDTO> crear(@RequestBody RequestTipoPersona requestTipoPersona){
        return  ResponseEntity.status(HttpStatus.OK)
                .body(tipoPersonaServiceIn.crearTipoPersonaIn(requestTipoPersona));
    }

    @Operation(summary = "Obtener un Tipo Persona por id")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoPersonaDTO> obtenerTipoDoc(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoPersonaServiceIn.obtenerTipoPersonaIn(id).get());
    }

    @Operation(summary = "Obtener todos los Tipo Personas")
    @GetMapping("/listar")
    public ResponseEntity<List<TipoPersonaDTO>> obtenerTodo(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoPersonaServiceIn.obtenerTodosIn());
    }
    @Operation(summary = "Actualizar un Tipo Persona")
    @PutMapping("/guardar/{id}")
    public ResponseEntity<TipoPersonaDTO> actualizar(@PathVariable Long id, @RequestBody RequestTipoPersona requestTipoDocumento){
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoPersonaServiceIn.actualizarIn(id, requestTipoDocumento));
    }
    @Operation(summary = "Eliminar un Tipo Persona")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<TipoPersonaDTO> eliminar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoPersonaServiceIn.deleteIn(id));
    }
}
