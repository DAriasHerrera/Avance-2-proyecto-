package com.mycompany.fideburguer.Prototipo;
import java.io.Serializable;

/**
 *
 * @author DiegoAriasHerrera
 */
public class AsignacionCajero implements Serializable {
    // Aqui defino los atributos de mi clase
    private String idAsignacion;
    private String fechaAsignacion;
    private Usuario usuario;
    private Sucursal sucursal;

    public AsignacionCajero(String idAsignacion, String fechaAsignacion, Usuario usuario, Sucursal sucursal) {
        this.idAsignacion = idAsignacion;
        this.fechaAsignacion = fechaAsignacion;
        this.usuario = usuario;
        this.sucursal = sucursal;
    }
    // Aqui establezco mis getters y setters

    public String getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
   
    
    
    
}
