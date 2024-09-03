package br.com.ekan.teste.service.impl;

import br.com.ekan.teste.dto.BeneficiarioDTO;
import br.com.ekan.teste.dto.mapper.BeneficiarioMapper;
import br.com.ekan.teste.exception.ResourceNotFoundException;
import br.com.ekan.teste.model.BeneficiarioEntity;
import br.com.ekan.teste.repository.BeneficiarioRepository;
import br.com.ekan.teste.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private final BeneficiarioRepository repository;

    @Autowired
    private final BeneficiarioMapper mapper;


    public BeneficiarioServiceImpl(BeneficiarioRepository repository, BeneficiarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BeneficiarioDTO cadastrar(BeneficiarioDTO beneficiarioDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(beneficiarioDTO)));
    }

    @Override
    public List<BeneficiarioDTO> listarTodos() {

        return mapper.toDTOs(repository.findAll());
    }

    @Override
    public BeneficiarioDTO atualizar(Long id ,BeneficiarioDTO beneficiarioDTO) {
        return  mapper.toDTO(repository.findById(id).map(
                r -> repository.save(mapper.updateBeneficiarioFromDto(beneficiarioDTO,r))
        ).orElseThrow(() ->  new ResourceNotFoundException("Beneficiario não encontrado com id : " + id)));
    }

    @Override
    public void apagar(Long id) {
         BeneficiarioEntity b =  repository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Beneficiario não encontrado com id : " + id));

        repository.deleteById(id);
    }
}
