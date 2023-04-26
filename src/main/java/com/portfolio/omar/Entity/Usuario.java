
package com.portfolio.omar.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 45, message = "no cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 45, message = "no cumple con la longitud")
    private String apellido;
    @Size(min = 1, max = 45, message = "no cumple con la longitud")
    private String cargoActual;
    @Size(min = 1, max = 350, message = "no cumple con la longitud")
    private String photoUrl;
    @NotNull
    @Size(min = 1, max = 350, message = "no cumple con la longitud")
    private String bannerUrl;
    @NotNull
    private String descripcion;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String cargoActual, String photoUrl, String bannerUrl, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargoActual = cargoActual;
        this.photoUrl = photoUrl;
        this.bannerUrl = bannerUrl;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
