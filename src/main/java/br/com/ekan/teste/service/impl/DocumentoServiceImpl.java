package br.com.ekan.teste.service.impl;

import br.com.ekan.teste.dto.BeneficiarioDTO;
import br.com.ekan.teste.dto.DocumentoDTO;
import br.com.ekan.teste.dto.mapper.DocumentoMapper;
import br.com.ekan.teste.repository.DocumentoRepository;
import br.com.ekan.teste.service.DocumentoService;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DocumentoServiceImpl implements DocumentoService {


    @Autowired
    private DocumentoRepository repository;

    @Autowired
    private DocumentoMapper mapper;

    @Override
    public DocumentoDTO cadastrar(Long idBeneficiario, DocumentoDTO documentoDTO) {
        return mapper.toDTO(repository.findById(documentoDTO.getId()).map( d ->
                     repository.save(mapper.updateDocumentoFromDto(documentoDTO,d))
        ).orElse(
                repository.save(mapper.toEntity(documentoDTO))));
    }

    @Override
    public Set<DocumentoDTO> listarPorBeneficiario(Long IdBeneficiario) {
        return mapper.toDTOs(repository.findByBeneficiarioId(IdBeneficiario));
    }
}
