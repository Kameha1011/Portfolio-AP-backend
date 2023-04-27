
package com.portfolio.omar.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author omrfl
 */
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombreProy;
    @NotNull
    private String descripcion;
    @NotNull
    private String imgUrl;
    @NotNull
    private String gitHubUrl;
    @NotNull
    private String proyectUrl;

    public Proyectos() {
    }

    public Proyectos(String nombreProy, String descripcion, String imgUrl, String gitHubUrl, String proyectUrl) {
        this.nombreProy = nombreProy;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.gitHubUrl = gitHubUrl;
        this.proyectUrl = proyectUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
