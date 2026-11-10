package com.mycompany.fideburguer.Prototipo;
import java.io.Serializable;

/**
 *
 * @author DiegoAriasHerrera
 */
public abstract class ElementoVenta implements Serializable {

    // Aqui defino los atributos de mi clase
    private String id;
    private String nombre;
    private String descripcion;
    private float precio;

    // Aqui defino mi constructor

    public ElementoVenta(String id, String nombre, String descripcion, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
// Aqui establezco mis getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    // Aqui defino los metodos abstractos
    public abstract float calcularPrecio();

    public abstract void mostrarInformacion();
    
}
