package com.codigo.msrodriguezesquivel.infraestructure.adapters;

import com.codigo.msrodriguezesquivel.domain.aggregates.constants.Constant;
import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoDocumentoDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoPersonaDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestPersona;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoDocumento;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoPersona;
import com.codigo.msrodriguezesquivel.domain.ports.out.TipoPersonaServiceOut;
import com.codigo.msrodriguezesquivel.domain.util.Util;
import com.codigo.msrodriguezesquivel.infraestructure.entity.TipoDocumentoEntity;
import com.codigo.msrodriguezesquivel.infraestructure.entity.TipoPersonaEntity;
import com.codigo.msrodriguezesquivel.infraestructure.mapper.TipoPersonaMapper;
import com.codigo.msrodriguezesquivel.infraestructure.repository.TipoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TipoPersonaAdapter implements TipoPersonaServiceOut {
    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;
    @Autowired
    private TipoPersonaMapper tipoPersonaMapper;
    @Autowired
    private Util utils;
    @Override
    public TipoPersonaDTO crearTipoPersonaOut(RequestTipoPersona requestTipoPersona) {
        TipoPersonaEntity entity = tipoPersonaRepository.save(getEntity(requestTipoPersona));
        return tipoPersonaMapper.mapToDTO(entity);
    }

    @Override
    public Optional<TipoPersonaDTO> obtenerTipoPersonaOut(Long id) {
        return Optional.ofNullable(tipoPersonaMapper.mapToDTO(tipoPersonaRepository.findById(id).get()));
    }


    @Override
    public List<TipoPersonaDTO> obtenerTodosOut() {
        List<TipoPersonaDTO> tipoPersona = new ArrayList<>();
        List<TipoPersonaEntity> entities = tipoPersonaRepository.findAll();
        if(!entities.isEmpty()){
            for(TipoPersonaEntity entity : entities){
                TipoPersonaDTO tipoPersonaDTO = tipoPersonaMapper.mapToDTO(entity);
                tipoPersona.add(tipoPersonaDTO);
            }
            return tipoPersona;
        }
        return null;
    }

    @Override
    public TipoPersonaDTO actualizarOut(Long id, RequestTipoPersona requestTipoPersona) {
        boolean existe = tipoPersonaRepository.existsById(id);
        if(existe){
            Optional<TipoPersonaEntity> entity = tipoPersonaRepository.findById(id);
            tipoPersonaRepository.save(getUpdate(requestTipoPersona, entity.get()));
            return tipoPersonaMapper.mapToDTO(getUpdate(requestTipoPersona, entity.get()));
        }
        return null;
    }

    @Override
    public TipoPersonaDTO deleteOut(Long id) {
        boolean existe = tipoPersonaRepository.existsById(id);
        if(existe){
            Optional<TipoPersonaEntity> entity = tipoPersonaRepository.findById(id);
            entity.get().setEstado(Constant.STATUS_DISABLED);
            entity.get().setDateDelet(utils.getTimestamp());
            entity.get().setUsuaDelet(Constant.AUDIT_ADMIN);
            tipoPersonaRepository.save(entity.get());
            return tipoPersonaMapper.mapToDTO(entity.get());
        }
        return null;
    }

    private TipoPersonaEntity getEntity(RequestTipoPersona requestTipoPersona){
        TipoPersonaEntity entity = new TipoPersonaEntity();
        entity.setCodTipo(requestTipoPersona.getCodTipo());
        entity.setDescTipo(requestTipoPersona.getDescTipo());
        entity.setEstado(Constant.STATUS_ACTIVE);
        entity.setDateCreate(utils.getTimestamp());
        entity.setUsuaCrea(Constant.AUDIT_ADMIN);
        return entity;
    }

    private TipoPersonaEntity getUpdate(RequestTipoPersona requestTipoPersona, TipoPersonaEntity entityActualizar){
        entityActualizar.setCodTipo(requestTipoPersona.getCodTipo());
        entityActualizar.setDescTipo(requestTipoPersona.getDescTipo());
        entityActualizar.setDateModif(utils.getTimestamp());
        entityActualizar.setUsuaModif(Constant.AUDIT_ADMIN);
        return entityActualizar;
    }
}
