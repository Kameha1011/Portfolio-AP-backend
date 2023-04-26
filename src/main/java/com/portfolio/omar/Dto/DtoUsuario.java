package com.portfolio.omar.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author omrfl
 */
public class DtoUsuario {

    private String nombre;
    private String apellido;
    private String cargoActual;
    private String photoUrl;
    private String bannerUrl;
    private String descripcion;

    public DtoUsuario() {
    }

    public DtoUsuario(String nombre, String apellido, String cargoActual, String photoUrl, String bannerUrl, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargoActual = cargoActual;
        this.photoUrl = photoUrl;
        this.bannerUrl = bannerUrl;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargoActual() {
        return cargoActual;
    }

    public void setCargoActual(String cargoActual) {
        this.cargoActual = cargoActual;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
