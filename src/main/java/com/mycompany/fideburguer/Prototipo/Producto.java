package com.mycompany.fideburguer.Prototipo;

/**
 *
 * @author DiegoAriasHerrera
 */
public class Producto extends ElementoVenta {

    // Aqui defino los atributos de mi clase
    private String categoria;

    // Aqui defino mi constructor

    public Producto(String id, String nombre, String descripcion,
            float precio, String categoria) {
        super(id, nombre, descripcion, precio);
        this.categoria = categoria;
    }
    // Aqui establezco mis getters y setters

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
 // Aqui implemento los metodos abstractos
    @Override
    public float calcularPrecio() {
        return getPrecio();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Producto: " + getNombre());
        System.out.println("Categoria: " + categoria);
        System.out.println("Precio: " + calcularPrecio());
    }   
    
}
