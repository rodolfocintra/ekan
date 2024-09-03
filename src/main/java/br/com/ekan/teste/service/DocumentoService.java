package br.com.ekan.teste.service;

import br.com.ekan.teste.dto.DocumentoDTO;

import java.util.Set;

public interface DocumentoService {


    DocumentoDTO cadastrar(Long idBeneficiario,DocumentoDTO documentoDTO);


    Set<DocumentoDTO> listarPorBeneficiario(Long IdBeneficiario);



}
