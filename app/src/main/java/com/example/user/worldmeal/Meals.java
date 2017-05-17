package com.example.user.worldmeal;

import java.io.Serializable;

public class Meals implements Serializable{

    private String nombre;
    private String categoria;
    private String area;
    private String instrucciones;
    private String imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
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
                ", categoria='" + categoria + '\'' +
                ", area='" + area + '\'' +
                ", instrucciones='" + instrucciones + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
