package com.codingforfun.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.junit.Test;
import org.openxava.annotations.CollectionView;
import org.openxava.annotations.Stereotype;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
public class Template extends Identifiable {

    /**
     * 	<for stereotype="DINERO" type="java.math.BigDecimal"/>
     * 	<for stereotype="MONEY" type="java.math.BigDecimal"/>
     * 	<for stereotype="TEXTO_GRANDE" type="java.lang.String"/>
     * 	<for stereotype="TEXT_AREA" type="java.lang.String"/>
     * 	<for stereotype="MEMO" type="java.lang.String"/>
     * 	<for stereotype="FOTO" type="byte[]"/>
     */

    @Stereotype("DINERO")
    private BigDecimal dinero;

    @Stereotype("MONEY")
    private BigDecimal money;

    @Stereotype("TEXTO_GRANDE")
    private String textoGrande;

    @Stereotype("TEXT_AREA")
    private String textArea;

    @Stereotype("MEMO")
    private String memo;

    @Stereotype("FOTO")
    private byte[] fotoByte;

/*    @Stereotype("FOTO")
    private String fotoString;*/

    /**
     * <for stereotype="IMAGEN" type="byte[]"/>
     * 	<for stereotype="PHOTO" type="byte[]"/>
     * 	<for stereotype="IMAGE" type="byte[]"/>
     * 	<for stereotype="HORA" type="String"/>
     * 	<for stereotype="TIME" type="String"/>
     * 	<for stereotype="ETIQUETA" type="String"/>
     * 	<for stereotype="LABEL" type="String"/>
     * 	<for stereotype="ETIQUETA_NEGRITA" type="String"/>
     * 	<for stereotype="BOLD_LABEL" type="String"/>
     * 	<for stereotype="DATETIME" type="java.sql.Timestamp"/>
     * 	<for stereotype="FECHAHORA" type="java.sql.Timestamp"/>
     * 	<for stereotype="IMAGES_GALLERY" type="String"/>
     */

    @Stereotype("IMAGEN")
    @Column(columnDefinition = "BLOB")
    private byte[] imagen;

    @Stereotype("PHOTO")
    @Column(columnDefinition = "CLOB")
    private byte[] photo;

    @Stereotype("IMAGE")
    private byte[] images;

    @Stereotype("HORA")
    private String hora;

    @Stereotype("TIME")
    private String time;

    @Stereotype("ETIQUETA")
    private String etiqueta;

    @Stereotype("BOLD_LABEL")
    private String boldLabel;

    @Stereotype("DATETIME")
    private Timestamp timestamp;

    @Stereotype("FECHAHORA")
    private Timestamp fechahora;

    @Stereotype("IMAGES_GALLERY")
    private String imageGallery;




}
