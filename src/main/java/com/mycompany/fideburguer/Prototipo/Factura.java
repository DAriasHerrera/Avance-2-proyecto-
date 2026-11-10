package com.mycompany.fideburguer.Prototipo;
import java.io.Serializable;

/**
 *
 * @author DiegoAriasHerrera
 */
public class Factura implements Serializable {

    // Aqui defino los atributos de mi clase
    private String idFactura;
    private String fecha;
    private String nombreCliente;
    private String identificacionCliente;
    private String correoCliente;
    private float subtotal;
    private float impuesto;
    private float total;
    private String estado;
    private Pedido pedido;
    // Aqui defino mi constructor

    public Factura(String idFactura, String fecha, String nombreCliente, String identificacionCliente, String correoCliente, Pedido pedido) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.identificacionCliente = identificacionCliente;
        this.correoCliente = correoCliente;
        this.pedido = pedido;
        this.estado = "Emitida";
        // Aqui calculo los montos de la factura
        calcularTotal();
    }
   // Aqui establezco mis getters y setters

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public float getTotal() {
        return total;
    }
    // Aqui calculo el subtotal, impuesto y total necesarios para la factura
    public void calcularTotal() {
        subtotal = pedido.calcularTotal();
        impuesto = subtotal * 0.13f;
        total = subtotal + impuesto;
    }
}
