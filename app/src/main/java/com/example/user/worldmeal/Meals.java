package com.example.user.worldmeal;

import java.io.Serializable;

public class Meals implements Serializable{

    private String nombre;
    private String strCategory;
    private String area;
    private String instrucciones;
    private String imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
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
                ", strCategory='" + strCategory + '\'' +
                ", area='" + area + '\'' +
                ", instrucciones='" + instrucciones + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
