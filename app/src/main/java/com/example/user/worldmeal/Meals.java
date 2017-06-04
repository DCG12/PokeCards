package com.example.user.worldmeal;

import java.io.Serializable;

public class Meals implements Serializable{

    private String nombre;
    private String tipo;
    private String vida;
    private String estado;
    private String clase;
    private String artista;
    private String serie;
    private String imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Meals{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", vida='" + vida + '\'' +
                ", estado='" + estado + '\'' +
                ", clase='" + clase + '\'' +
                ", artista='" + artista + '\'' +
                ", serie='" + serie + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
