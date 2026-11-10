package com.mycompany.fideburguer.Prototipo;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DiegoAriasHerrera
 */
public class Pedido implements Serializable {

    // Aqui defino los atributos de mi clase
    private String idPedido;
    private String fecha;
    private String nombreCliente;
    private String metodoPago;
    private EstadoPedido estado;
    private ArrayList<DetallePedido> detalles;
    // Aqui defino mi constructor

    public Pedido(String idPedido, String fecha, String nombreCliente, String metodoPago) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.metodoPago = metodoPago;
        this.estado = EstadoPedido.Pendiente;
        detalles = new ArrayList<>();
    }
     // Aqui establezco mis getters y setters

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
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

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public ArrayList<DetallePedido> getDetalles() {
        return detalles;
    }

    // Aqui agrego detalles al pedido
    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
    }

    // Aqui calculo el total del pedido
    public float calcularTotal() {

        float total = 0;

        for (int i = 0; i < detalles.size(); i++) {
            total = total + detalles.get(i).getSubtotal();
        }

        return total;
    }

    // Aqui muestro la informacion del pedido
    public void mostrarInformacion() {

        System.out.println("Pedido: " + idPedido);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Estado: " + estado);
        System.out.println("Total: " + calcularTotal());
    }
}
