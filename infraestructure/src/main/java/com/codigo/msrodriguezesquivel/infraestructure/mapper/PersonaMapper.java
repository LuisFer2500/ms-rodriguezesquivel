package com.codigo.msrodriguezesquivel.infraestructure.mapper;

import com.codigo.msrodriguezesquivel.domain.aggregates.dto.PersonaDTO;
import com.codigo.msrodriguezesquivel.infraestructure.entity.PersonaEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonaMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public PersonaDTO mapToDTO(PersonaEntity entity){
        return modelMapper.map(entity, PersonaDTO.class);
    }

    public PersonaEntity mapToEntity(PersonaDTO dto){
        return modelMapper.map(dto, PersonaEntity.class);
    }

    public List<PersonaDTO> mapToDTOList(List<PersonaEntity> personaEntities) {

        Type listType = new TypeToken<List<PersonaDTO>>() {}.getType();
        return modelMapper.map(personaEntities, listType);
    }
}
