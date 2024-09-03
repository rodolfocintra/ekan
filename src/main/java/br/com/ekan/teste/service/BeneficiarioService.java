package br.com.ekan.teste.service;

import br.com.ekan.teste.dto.BeneficiarioDTO;

import java.util.List;

public interface BeneficiarioService {


    BeneficiarioDTO cadastrar(BeneficiarioDTO beneficiarioDTO);


    List<BeneficiarioDTO> listarTodos();

    BeneficiarioDTO atualizar(Long id ,BeneficiarioDTO beneficiarioDTO);


    void apagar( Long id);
}
