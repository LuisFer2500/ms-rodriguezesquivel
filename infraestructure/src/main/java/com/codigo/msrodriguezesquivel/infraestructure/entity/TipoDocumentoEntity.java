package com.codigo.msrodriguezesquivel.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@NamedQuery(name = "TipoDocumentoEntity.findByCodTipo", query = "select a from TipoDocumentoEntity a where a.codTipo=:codTipo")
@Entity
@Table(name = "tipo_documento")
@Getter
@Setter
public class TipoDocumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private Long idTipoDocumento;

    @Column(name = "cod_tipo", nullable = false)
    private String codTipo;

    @Column(name = "desc_tipo", nullable = false)
    private String descTipo;

    @Column(name = "estado", nullable = false)
    private int estado;

    @Column(name = "usua_crea")
    private String usuaCrea;

    @Column(name = "date_create")
    private Timestamp dateCreate;

    @Column(name = "usua_modif")
    private String usuaModif;

    @Column(name = "date_modif")
    private Timestamp dateModif;

    @Column(name = "usua_delet")
    private String usuaDelet;

    @Column(name = "date_delet")
    private Timestamp dateDelet;

}
