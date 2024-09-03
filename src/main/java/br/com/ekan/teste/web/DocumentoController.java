package br.com.ekan.teste.web;

import br.com.ekan.teste.dto.DocumentoDTO;
import br.com.ekan.teste.service.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping(value = "/documento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Tag(name = "Documentos")
@AllArgsConstructor
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @GetMapping ("/{id}")
    @Operation(
            summary = "Get",
            description = "Buscar documentos por id beneficiario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sucesso na criacao do beneficiario")
    })
    public ResponseEntity<Set<DocumentoDTO>> atualizar(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorBeneficiario(id));
    }
}
