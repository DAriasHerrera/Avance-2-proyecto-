package com.mycompany.fideburguer.Prototipo;
import java.util.ArrayList;

/**
 *
 * @author DiegoAriasHerrera
 */
public class Combo extends ElementoVenta {

    // Aqui defino el arreglo de productos
    private ArrayList<Producto> productos;

    // Aqui defino mi constructor

    public Combo(String id, String nombre, String descripcion, float precio) {
        super(id, nombre, descripcion, precio);
        this.productos = new ArrayList<>();
    }
    // Aqui establezco mis metodos para administrar productos
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void quitarProducto(Producto producto) {
        productos.remove(producto);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    // Aqui implemento los metodos abstractos
    @Override
    public float calcularPrecio() {
        return getPrecio();
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("Combo: " + getNombre());
        System.out.println("Precio: " + calcularPrecio());
        System.out.println("Productos incluidos:");

        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i).getNombre());
        }
    }
    
}
