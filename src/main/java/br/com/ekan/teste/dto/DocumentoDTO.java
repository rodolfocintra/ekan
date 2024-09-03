package br.com.ekan.teste.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoDTO implements Serializable {

    private static final long serialVersionUID = -4113438863230742538L;
    private Long id;

    private String tipoDocumento;

    private String descricao;

    private Instant dataInclusao ;

    private Instant dataAtualizacao ;
}
