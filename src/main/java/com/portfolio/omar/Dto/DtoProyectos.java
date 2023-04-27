
package com.portfolio.omar.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author omrfl
 */
public class DtoProyectos {
    @NotBlank
    private String nombreProy;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imgUrl;
    @NotBlank
    private String gitHubUrl;
    @NotBlank
    private String proyectUrl;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombreProy, String descripcion, String imgUrl, String gitHubUrl, String proyectUrl) {
        this.nombreProy = nombreProy;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.gitHubUrl = gitHubUrl;
        this.proyectUrl = proyectUrl;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public String getProyectUrl() {
        return proyectUrl;
    }

    public void setProyectUrl(String proyectUrl) {
        this.proyectUrl = proyectUrl;
    }
    
    
}
