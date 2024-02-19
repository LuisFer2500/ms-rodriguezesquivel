package com.codigo.msrodriguezesquivel.infraestructure.mapper;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoDocumentoDTO;
import com.codigo.msrodriguezesquivel.infraestructure.entity.TipoDocumentoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TipoDocumentoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public TipoDocumentoDTO mapToDTO(TipoDocumentoEntity entity){
        return modelMapper.map(entity, TipoDocumentoDTO.class);
    }

    public TipoDocumentoEntity mapToEntity(TipoDocumentoDTO dto){
        return modelMapper.map(dto, TipoDocumentoEntity.class);
    }

}
