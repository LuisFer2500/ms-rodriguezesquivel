package com.codigo.msrodriguezesquivel.application.controller;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoDocumentoDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoDocumento;
import com.codigo.msrodriguezesquivel.domain.ports.in.TipoDocumentoServiceIn;
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
                title = "API-TIPO DOCUMENTO",
                version = "1.0",
                description = "Mantenimiento de un Tipo de Documento"
        )
)
@RestController
@RequestMapping("/v2/tipoDoc")
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoServiceIn tipoDocumentoServiceIn;

    @Operation(summary = "Crear un Tipo Documento")
    @PostMapping("/crear")
    public ResponseEntity<TipoDocumentoDTO> crear(@RequestBody RequestTipoDocumento requestTipoDocumento){
        return  ResponseEntity.status(HttpStatus.OK)
                .body(tipoDocumentoServiceIn.crearTipoDocumentoIn(requestTipoDocumento));
    }

    @Operation(summary = "Obtener un Tipo Documento por id")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoDocumentoDTO> obtenerTipoDoc(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoDocumentoServiceIn.obtenerTipoDocumentoIn(id).get());
    }

    @Operation(summary = "Obtener todos los Tipo Documento")
    @GetMapping("/listar")
    public ResponseEntity<List<TipoDocumentoDTO>> obtenerTodo(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoDocumentoServiceIn.obtenerTodosIn());
    }
    @Operation(summary = "Actualizar un Tipo Documento")
    @PutMapping("/guardar/{id}")
    public ResponseEntity<TipoDocumentoDTO> actualizar(@PathVariable Long id, @RequestBody RequestTipoDocumento requestTipoDocumento){
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoDocumentoServiceIn.actualizarIn(id, requestTipoDocumento));
    }
    @Operation(summary = "Eliminar un Tipo Documento")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<TipoDocumentoDTO> eliminar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoDocumentoServiceIn.deleteIn(id));
    }
}
