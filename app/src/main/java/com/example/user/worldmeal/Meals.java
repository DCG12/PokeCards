package com.example.user.worldmeal;



public class Meals {

    private String nombre;
    private String categoria;
    private String procedencia;
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

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
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
                ", procedencia='" + procedencia + '\'' +
                ", instrucciones='" + instrucciones + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}