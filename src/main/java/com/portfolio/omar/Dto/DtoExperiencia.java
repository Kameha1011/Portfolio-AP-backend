
package com.portfolio.omar.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author omrfl
 */
public class DtoExperiencia {
    @NotBlank
    private String nombreEmpresa;
    @NotBlank
    private String descripcion;
    
    //CONSTRUCTORES

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreEmpresa, String descripcion) {
        this.nombreEmpresa = nombreEmpresa;
        this.descripcion = descripcion;
    }
    //GETTERS N SETTERS

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
