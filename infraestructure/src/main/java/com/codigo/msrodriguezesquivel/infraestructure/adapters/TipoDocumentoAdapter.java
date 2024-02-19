package com.codigo.msrodriguezesquivel.infraestructure.adapters;

import com.codigo.msrodriguezesquivel.domain.aggregates.constants.Constant;
import com.codigo.msrodriguezesquivel.domain.aggregates.dto.TipoDocumentoDTO;
import com.codigo.msrodriguezesquivel.domain.aggregates.request.RequestTipoDocumento;
import com.codigo.msrodriguezesquivel.domain.ports.out.TipoDocumentoServiceOut;
import com.codigo.msrodriguezesquivel.domain.util.Util;
import com.codigo.msrodriguezesquivel.infraestructure.entity.TipoDocumentoEntity;
import com.codigo.msrodriguezesquivel.infraestructure.mapper.TipoDocumentoMapper;
import com.codigo.msrodriguezesquivel.infraestructure.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TipoDocumentoAdapter implements TipoDocumentoServiceOut {
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    private TipoDocumentoMapper tipoDocumentoMapper;
    @Autowired
    private Util utils;

    @Override
    public TipoDocumentoDTO crearTipoDocumentoOut(RequestTipoDocumento requestTipoDocumento) {
        TipoDocumentoEntity entity = tipoDocumentoRepository.save(getEntity(requestTipoDocumento));
        return tipoDocumentoMapper.mapToDTO(entity);
    }

    @Override
    public Optional<TipoDocumentoDTO> obtenerTipoDocumentoOut(Long id) {
        return Optional.ofNullable(tipoDocumentoMapper.mapToDTO(tipoDocumentoRepository.findById(id).get()));
    }

    @Override
    public List<TipoDocumentoDTO> obtenerTodosOut() {
        List<TipoDocumentoDTO> tipoDocumentoDTOList = new ArrayList<>();
        List<TipoDocumentoEntity> entities = tipoDocumentoRepository.findAll();
        if(!entities.isEmpty()){
            for(TipoDocumentoEntity entity : entities){
                TipoDocumentoDTO tipoDocumentoDTO = tipoDocumentoMapper.mapToDTO(entity);
                tipoDocumentoDTOList.add(tipoDocumentoDTO);
            }
            return tipoDocumentoDTOList;
        }
        return null;
    }

    @Override
    public TipoDocumentoDTO actualizarOut(Long id, RequestTipoDocumento requestTipoDocumento) {
        boolean existe = tipoDocumentoRepository.existsById(id);
        if(existe){
            Optional<TipoDocumentoEntity> entity = tipoDocumentoRepository.findById(id);
            tipoDocumentoRepository.save(getUpdate(requestTipoDocumento, entity.get()));
            return tipoDocumentoMapper.mapToDTO(getUpdate(requestTipoDocumento, entity.get()));
        }
        return null;
    }

    @Override
    public TipoDocumentoDTO deleteOut(Long id) {
        boolean existe = tipoDocumentoRepository.existsById(id);
        if(existe){
            Optional<TipoDocumentoEntity> entity = tipoDocumentoRepository.findById(id);
            entity.get().setEstado(Constant.STATUS_DISABLED);
            entity.get().setDateDelet(utils.getTimestamp());
            entity.get().setUsuaDelet(Constant.AUDIT_ADMIN);
            tipoDocumentoRepository.save(entity.get());
            return tipoDocumentoMapper.mapToDTO(entity.get());
        }
        return null;
    }

    private TipoDocumentoEntity getEntity(RequestTipoDocumento requestTipoDocumento){
        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        entity.setCodTipo(requestTipoDocumento.getCodTipo());
        entity.setDescTipo(requestTipoDocumento.getDescTipo());
        entity.setEstado(Constant.STATUS_ACTIVE);
        entity.setDateCreate(utils.getTimestamp());
        entity.setUsuaCrea(Constant.AUDIT_ADMIN);
        return entity;
    }

    private TipoDocumentoEntity getUpdate(RequestTipoDocumento requestTipoDocumento, TipoDocumentoEntity entityActualizar){
        entityActualizar.setCodTipo(requestTipoDocumento.getCodTipo());
        entityActualizar.setDescTipo(requestTipoDocumento.getDescTipo());
        entityActualizar.setDateModif(utils.getTimestamp());
        entityActualizar.setUsuaModif(Constant.AUDIT_ADMIN);
        return entityActualizar;
    }
}
