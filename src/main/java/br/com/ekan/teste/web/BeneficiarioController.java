package br.com.ekan.teste.web;



import br.com.ekan.teste.dto.BeneficiarioDTO;
import br.com.ekan.teste.service.BeneficiarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/beneficiario", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Tag(name = "Beneficiario", description = "Api responsavel en fazer o crud de beneficiario")
public class BeneficiarioController {


    @Autowired
    private final BeneficiarioService service;

    public BeneficiarioController(BeneficiarioService service) {
        this.service = service;
    }

    @PostMapping("/adicionar")
    @Operation(
            summary  = "save",
            description  = "Criar Benefifiario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sucesso na criacao do beneficiario")
    })
    public ResponseEntity<BeneficiarioDTO> criar(@RequestBody BeneficiarioDTO beneficiarioDTO) {
        return ResponseEntity.ok(service.cadastrar(beneficiarioDTO));
    }

    @GetMapping("/")
    @Operation(
            summary = "findAll",
            description = "Busca todos Beneficiarioos")
    public ResponseEntity<List<BeneficiarioDTO>> findAll() {

        return ResponseEntity.ok(service.listarTodos());
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "update",
            description = "Atualizar benefidiario por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sucesso na criacao do beneficiario")
    })
    public ResponseEntity<BeneficiarioDTO> atualizar(@PathVariable Long id, @RequestBody BeneficiarioDTO beneficiarioDTO) {

        return ResponseEntity.ok(service.atualizar(id,beneficiarioDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "delete",
            description = "Apagar benefidiario por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sucesso na criacao do beneficiario")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.apagar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
