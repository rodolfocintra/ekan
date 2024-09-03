package br.com.ekan.teste.dto.mapper;

import br.com.ekan.teste.dto.BeneficiarioDTO;
import br.com.ekan.teste.model.BeneficiarioEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel="spring" ,
        uses = DocumentoMapper.class)
public interface BeneficiarioMapper {

    BeneficiarioDTO toDTO (BeneficiarioEntity entity);

    BeneficiarioEntity toEntity( BeneficiarioDTO dto);

    List<BeneficiarioDTO> toDTOs (List<BeneficiarioEntity> entitys);

    List<BeneficiarioEntity> toEntitys( List<BeneficiarioDTO> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BeneficiarioEntity updateBeneficiarioFromDto(BeneficiarioDTO dto,@MappingTarget BeneficiarioEntity entity);


    @AfterMapping
    default void mapBeneficiarioInDocumento(@MappingTarget BeneficiarioEntity entity){
        entity.getDocumentos().stream().forEach(d -> d.setBeneficiario(entity));
    }


}
