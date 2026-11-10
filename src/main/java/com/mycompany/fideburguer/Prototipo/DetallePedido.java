package com.mycompany.fideburguer.Prototipo;
import java.io.Serializable;

/**
 *
 * @author DiegoAriasHerrera
 */
public class DetallePedido implements Serializable {

    // Aqui defino los atributos de mi clase
    private int cantidad;
    private float precioUnitario;
    private float subtotal;
    private ElementoVenta elementoVenta;

    public DetallePedido(int cantidad, ElementoVenta elementoVenta) {
        this.cantidad = cantidad;
        this.precioUnitario = elementoVenta.calcularPrecio();
        this.elementoVenta = elementoVenta;
        // Aqui calculo el subtotal
        calcularSubtotal();
    }
 // Aqui establezco mis getters y setters

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
        calcularSubtotal();
    }

    public float getSubtotal() {
        return subtotal;
    }

    public ElementoVenta getElementoVenta() {
        return elementoVenta;
    }

    public void setElementoVenta(ElementoVenta elementoVenta) {
        this.elementoVenta = elementoVenta;
        this.precioUnitario = elementoVenta.calcularPrecio();
        calcularSubtotal();
    }

    // Aqui calculo el subtotal 
    public void calcularSubtotal() {
        subtotal = cantidad * precioUnitario;
    }
    
    
    
}
