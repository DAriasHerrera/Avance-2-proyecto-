package com.mycompany.fideburguer.Prototipo;
import java.io.Serializable;

/**
 *
 * @author DiegoAriasHerrera
 */
public class Usuario implements Serializable {
    // Aqui defino los atributos de mi clase
    private String idUsuario;
    private String nombre;
    private String nombreUsuario;
    private String contrasena;
    private String correo;
    private String telefono;
    private String perfil;

    public Usuario(String idUsuario, String nombre, String nombreUsuario, String contrasena, String correo, String telefono, String perfil) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.perfil = perfil;
    }
// Aqui establezco mis getters y setters   

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
}
