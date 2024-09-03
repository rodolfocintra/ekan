package br.com.ekan.teste.dto.mapper;



import br.com.ekan.teste.dto.DocumentoDTO;
import br.com.ekan.teste.model.DocumentoEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


import java.util.Set;

@Mapper(componentModel="spring",
        uses = BeneficiarioMapper.class)
public interface DocumentoMapper {

    DocumentoDTO toDTO (DocumentoEntity entity);



    DocumentoEntity toEntity( DocumentoDTO dto);


   Set<DocumentoDTO> toDTOs (Set<DocumentoEntity> entitys);

    Set<DocumentoEntity> toEntitys( Set<DocumentoDTO> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentoEntity updateDocumentoFromDto(DocumentoDTO dto, @MappingTarget DocumentoEntity entity);


}
