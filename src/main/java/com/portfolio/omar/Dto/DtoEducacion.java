
package com.portfolio.omar.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author omrfl
 */
public class DtoEducacion {
    @NotBlank
    private String nombreInstitucion;
    @NotBlank
    private String titulo;
    
    // constructores

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreInstitucion, String titulo) {
        this.nombreInstitucion = nombreInstitucion;
        this.titulo = titulo;
    }
    //getters n setters
    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
