package br.com.ekan.teste.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "nome",
        "telefone",
        "dataNascimento",
        "documentos",
        "dataAtualizacao",
        "dataInclusao"
})
public class BeneficiarioDTO implements Serializable {


    private Long id;

    private String nome;

    private Long telefone;

    private LocalDate dataNascimento;

    private Instant dataInclusao ;

    private Instant dataAtualizacao ;

    private Set<DocumentoDTO> documentos;

}
