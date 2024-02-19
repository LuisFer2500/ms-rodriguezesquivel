package com.codigo.msrodriguezesquivel.infraestructure.mapper;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoDocumentoDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoPersonaDTO;
import com.codigo.msrodriguezesquivel.infraestructure.entity.TipoDocumentoEntity;
import com.codigo.msrodriguezesquivel.infraestructure.entity.TipoPersonaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TipoPersonaMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public TipoPersonaDTO mapToDTO(TipoPersonaEntity entity){
        return modelMapper.map(entity, TipoPersonaDTO.class);
    }

    public TipoPersonaEntity mapToEntity(TipoPersonaEntity dto){
        return modelMapper.map(dto, TipoPersonaEntity.class);
    }
}
