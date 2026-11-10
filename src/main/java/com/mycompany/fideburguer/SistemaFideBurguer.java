package com.mycompany.fideburguer;
import com.mycompany.fideburguer.Prototipo.Usuario;
import com.mycompany.fideburguer.Prototipo.Producto;
import com.mycompany.fideburguer.Prototipo.Combo;
import com.mycompany.fideburguer.Prototipo.Sucursal;
import com.mycompany.fideburguer.Prototipo.AsignacionCajero;
import com.mycompany.fideburguer.Prototipo.Pedido;
import com.mycompany.fideburguer.Prototipo.Factura;
import com.mycompany.fideburguer.Repositorio.RepositorioUsuarios;
import com.mycompany.fideburguer.Repositorio.RepositorioProductos;
import com.mycompany.fideburguer.Repositorio.RepositorioCombos;
import com.mycompany.fideburguer.Repositorio.RepositorioSucursales;
import com.mycompany.fideburguer.Repositorio.RepositorioAsignaciones;
import com.mycompany.fideburguer.Repositorio.RepositorioPedidos;
import com.mycompany.fideburguer.Repositorio.RepositorioFacturas;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author DiegoAriasHerrera
 */
public class SistemaFideBurguer {
    // Aqui defino mi lista de usuarios y el repositorio
    private ArrayList<Usuario> usuarios;
    private RepositorioUsuarios repositorioUsuarios;
    // Aqui defino mi lista de productos y su repositorio
    private ArrayList<Producto> productos;
    private RepositorioProductos repositorioProductos;
    // Aqui defino mi lista de combos y su repositorio
    private List<Combo> combos;
    private RepositorioCombos repositorioCombos;
    // Aqui defino mi lista de sucursales y su repositorio
    private List<Sucursal> sucursales;
    private RepositorioSucursales repositorioSucursales;

    // Aqui inicio el repositorio de usuarios
    public SistemaFideBurguer() {
        repositorioUsuarios = new RepositorioUsuarios(new File("usuarios.dat"));
        repositorioProductos = new RepositorioProductos(new File("productos.dat"));
        repositorioCombos = new RepositorioCombos(new File("combos.dat"));
        repositorioSucursales = new RepositorioSucursales(new File("sucursales.dat"));
    }

    // Aqui inicio el sistema FideBurguer
    public void ejecutar() throws IOException, ClassNotFoundException {

        // Aqui recupero los datos almacenados
        usuarios = repositorioUsuarios.cargar();
        productos = repositorioProductos.cargar();
        combos = repositorioCombos.cargar();
        sucursales = repositorioSucursales.cargar();

        // Aqui registro los datos iniciales
        registrarDatosIniciales();

        System.out.println("Sistema FideBurguer iniciado correctamente.");
    }
    // Aqui registro los datos iniciales del sistema
    public void registrarDatosIniciales() throws IOException {

        // Aqui registro el usuario administrador
        if (usuarios.isEmpty()) {

            Usuario administrador = new Usuario(
                    "U001",
                    "Admin",
                    "admin",
                    "1234",
                    "administracion@fideburguer.com",
                    "912371239",
                    "administracion"
            );

            registrarUsuario(administrador);
        }

        // Aqui registro el producto inicial
        if (productos.isEmpty()) {

            Producto producto = new Producto(
                    "P001",
                    "Hamburguesa",
                    "Hamburguesa de carne",
                    2500.0f,
                    "Comida"
            );

            registrarProducto(producto);
        }

        // Aqui registro el combo inicial
        if (combos.isEmpty()) {

            Combo combo = new Combo(
                    "C001",
                    "Combo Hamburguesa",
                    "Hamburguesa con bebida",
                    3500.0f
            );

            if (!productos.isEmpty()) {
                combo.agregarProducto(productos.get(0));
            }

            registrarCombo(combo);
        }

        // Aqui registro la sucursal inicial
        if (sucursales.isEmpty()) {

            Sucursal sucursal = new Sucursal(
                    "S001",
                    "FideBurguer Central",
                    "San Jose Centro",
                    "22223333",
                    "Activa"
            );

            registrarSucursal(sucursal);
        }
    }
    // Aqui retorno la lista de usuarios registrados
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    // Aqui retorno la lista de productos registrados
    public ArrayList<Producto> getProductos() {
    return productos;
    }
    // Aqui retorno la lista de combos registrados
    public List<Combo> getCombos() {
    return combos;
    }
    
//CRUD para Usuarios 
    // Aqui defino el metodo para registrar un nuevo usuario
    public void registrarUsuario(Usuario nuevo) throws IOException {

        // Aqui verifico que el usuario no este registrado
        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getIdUsuario().equals(nuevo.getIdUsuario())) {
                System.out.println("El ID del usuario ya existe.");
                return;
            }
        }

        // Aqui agrego el usuario a la lista
        usuarios.add(nuevo);

        // Aqui guardo la lista actualizada
        repositorioUsuarios.guardar(usuarios);

        System.out.println("Usuario registrado correctamente.");
    }
    
    // Aqui defino el metodo para mostar los usuarios registrados
    public void consultarUsuarios() {

        System.out.println("\n=== USUARIOS REGISTRADOS ===");

        if (usuarios.isEmpty()) {

            System.out.println("No hay usuarios registrados.");

        } else {

            for (int i = 0; i < usuarios.size(); i++) {

                System.out.println("ID: " + usuarios.get(i).getIdUsuario());
                System.out.println("Nombre: " + usuarios.get(i).getNombre());
                System.out.println("Usuario: " + usuarios.get(i).getNombreUsuario());
                System.out.println("Correo: " + usuarios.get(i).getCorreo());
                System.out.println("Telefono: " + usuarios.get(i).getTelefono());
                System.out.println("Perfil: " + usuarios.get(i).getPerfil());
                System.out.println();
            }
            
        }
    }
     // Aqui defino el metodo para actualizar la informacion de un usuario
    public void actualizarUsuario(String idUsuario, String nombre,
            String nombreUsuario, String contrasena, String correo,
            String telefono, String perfil) throws IOException {

        // Aqui busco el usuario por su ID
        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getIdUsuario().equals(idUsuario)) {

                // Aqui actualizo los datos del usuario
                usuarios.get(i).setNombre(nombre);
                usuarios.get(i).setNombreUsuario(nombreUsuario);
                usuarios.get(i).setContrasena(contrasena);
                usuarios.get(i).setCorreo(correo);
                usuarios.get(i).setTelefono(telefono);
                usuarios.get(i).setPerfil(perfil);

                // Aqui guardo la lista actualizada
                repositorioUsuarios.guardar(usuarios);

                System.out.println("Usuario actualizado correctamente.");
                return;
            }
        }

        System.out.println("No se encontro el usuario.");
    }
     // Aqui defino el metodo para eliminar un usuario registrado
    public void eliminarUsuario(String idUsuario) throws IOException {

        // Aqui busco el usuario por su ID
        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getIdUsuario().equals(idUsuario)) {

                // Aqui elimino el usuario de la lista
                usuarios.remove(i);

                // Aqui guardo la lista actualizada
                repositorioUsuarios.guardar(usuarios);

                System.out.println("Usuario eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontro el usuario.");
    }
    
    
//CRUD para productos
    // Aqui defino el metodo para registrar un nuevo producto
    public void registrarProducto(Producto nuevo) throws IOException {

        // Aqui verifico que el producto no este registrado
        for (int i = 0; i < productos.size(); i++) {

            if (productos.get(i).getId().equals(nuevo.getId())) {

                System.out.println("El ID del producto ya existe.");
                return;
            }
        }

        // Aqui agrego el producto a la lista
        productos.add(nuevo);

        // Aqui guardo la lista actualizada
        repositorioProductos.guardar(productos);

        System.out.println("Producto registrado correctamente.");
    }
    // Aqui defino el metodo para mostar los productos registrados
    public void consultarProductos() {

        System.out.println("\n=== PRODUCTOS REGISTRADOS ===");

        if (productos.isEmpty()) {

            System.out.println("No hay productos registrados.");

        } else {

            for (int i = 0; i < productos.size(); i++) {

                System.out.println("ID: " + productos.get(i).getId());
                System.out.println("Nombre: " + productos.get(i).getNombre());
                System.out.println("Descripcion: " + productos.get(i).getDescripcion());
                System.out.println("Precio: " + productos.get(i).getPrecio());
                System.out.println("Categoria: " + productos.get(i).getCategoria());
                System.out.println();
            }
        }
    }
      // Aqui defino el metodo para actualizar la informacion de un producto
    public void actualizarProducto(String id, String nombre,
            String descripcion, float precio, String categoria)
            throws IOException {

        // Aqui busco el producto por su ID
        for (int i = 0; i < productos.size(); i++) {

            if (productos.get(i).getId().equals(id)) {

                // Aqui actualizo los datos del producto
                productos.get(i).setNombre(nombre);
                productos.get(i).setDescripcion(descripcion);
                productos.get(i).setPrecio(precio);
                productos.get(i).setCategoria(categoria);

                // Aqui guardo la lista actualizada
                repositorioProductos.guardar(productos);

                System.out.println("Producto actualizado correctamente.");
                return;
            }
        }

        System.out.println("No se encontro el producto.");
    }
    // Aqui defino el metodo para eliminar un producto de la lista
    public void eliminarProducto(String id) throws IOException {

        // Aqui busco el producto por su ID
        for (int i = 0; i < productos.size(); i++) {

            if (productos.get(i).getId().equals(id)) {

                // Aqui elimino el producto de la lista
                productos.remove(i);

                // Aqui guardo la lista actualizada
                repositorioProductos.guardar(productos);

                System.out.println("Producto eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontro el producto.");
    }
//CRUD para Combos
     // Aqui defino el metodo para registrar un nuevo combo
    public void registrarCombo(Combo nuevo) throws IOException {

        // Aqui verifico que el combo no este registrado
        for (int i = 0; i < combos.size(); i++) {

            if (combos.get(i).getId().equals(nuevo.getId())) {

                System.out.println("El ID del combo ya existe.");
                return;
            }
        }

        // Aqui agrego el combo a la lista
        combos.add(nuevo);

        // Aqui guardo la lista actualizada
        repositorioCombos.guardar(combos);

        System.out.println("Combo registrado correctamente.");
    }
    // Aqui defino el metodo para mostar los combos registrados
    public void consultarCombos() {

        System.out.println("\n=== COMBOS REGISTRADOS ===");

        if (combos.isEmpty()) {

            System.out.println("No hay combos registrados.");

        } else {

            for (int i = 0; i < combos.size(); i++) {

                System.out.println("ID: " + combos.get(i).getId());
                System.out.println("Nombre: " + combos.get(i).getNombre());
                System.out.println("Descripcion: " + combos.get(i).getDescripcion());
                System.out.println("Precio: " + combos.get(i).calcularPrecio());
                System.out.println("Productos incluidos:");

                for (int j = 0; j < combos.get(i).getProductos().size(); j++) {

                    System.out.println(
                            combos.get(i).getProductos().get(j).getNombre()
                    );
                }
                System.out.println();

            }
        }
    }
    // Aqui defino el metodo para actualizar la informacion de un combo
    public void actualizarCombo(String id, String nombre,
            String descripcion, float precio) throws IOException {

        // Aqui busco el combo por su ID
        for (int i = 0; i < combos.size(); i++) {

            if (combos.get(i).getId().equals(id)) {

                // Aqui actualizo los datos del combo
                combos.get(i).setNombre(nombre);
                combos.get(i).setDescripcion(descripcion);
                combos.get(i).setPrecio(precio);

                // Aqui guardo la lista actualizada
                repositorioCombos.guardar(combos);

                System.out.println("Combo actualizado correctamente.");
                return;
            }
        }

        System.out.println("No se encontro el combo.");
    }
     // Aqui defino el metodo para eliminar un combo 
    public void eliminarCombo(String id) throws IOException {

        // Aqui busco el combo por su ID
        for (int i = 0; i < combos.size(); i++) {

            if (combos.get(i).getId().equals(id)) {

                // Aqui elimino el combo de la lista
                combos.remove(i);

                // Aqui guardo la lista actualizada
                repositorioCombos.guardar(combos);

                System.out.println("Combo eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontro el combo.");
    }
//CRUD para Sucursales 
    // Aqui defino el metodo para registrar una nueva sucursal
    public void registrarSucursal(Sucursal nueva) throws IOException {

        // Aqui verifico que la sucursal no este registrada
        for (int i = 0; i < sucursales.size(); i++) {

            if (sucursales.get(i).getIdSucursal().equals(nueva.getIdSucursal())) {

                System.out.println("El ID de la sucursal ya existe.");
                return;
            }
        }

        // Aqui agrego la sucursal a la lista
        sucursales.add(nueva);

        // Aqui guardo la lista actualizada
        repositorioSucursales.guardar(sucursales);

        System.out.println("Sucursal registrada correctamente.");
    }
    // Aqui defino el metodo para mostar las sucursales registradas
    public void consultarSucursales() {

        System.out.println("\n=== SUCURSALES REGISTRADAS ===");

        if (sucursales.isEmpty()) {

            System.out.println("No hay sucursales registradas.");

        } else {

            for (int i = 0; i < sucursales.size(); i++) {

                System.out.println("ID: " + sucursales.get(i).getIdSucursal());
                System.out.println("Nombre: " + sucursales.get(i).getNombre());
                System.out.println("Direccion: " + sucursales.get(i).getDireccion());
                System.out.println("Telefono: " + sucursales.get(i).getTelefono());
                System.out.println("Estado: " + sucursales.get(i).getEstado());
                System.out.println();
            }
        }
    }
    // Aqui defino el metodo para actualizar la informacion de una sucursal
    public void actualizarSucursal(String idSucursal, String nombre,
            String direccion, String telefono, String estado)
            throws IOException {

        // Aqui busco la sucursal por su ID
        for (int i = 0; i < sucursales.size(); i++) {

            if (sucursales.get(i).getIdSucursal().equals(idSucursal)) {

                // Aqui actualizo los datos de la sucursal
                sucursales.get(i).setNombre(nombre);
                sucursales.get(i).setDireccion(direccion);
                sucursales.get(i).setTelefono(telefono);
                sucursales.get(i).setEstado(estado);

                // Aqui guardo la lista actualizada
                repositorioSucursales.guardar(sucursales);

                System.out.println("Sucursal actualizada correctamente.");
                return;
            }
        }

        System.out.println("No se encontro la sucursal.");
    }
    // // Aqui defino el metodo para elimina una sucursal registrada
    public void eliminarSucursal(String idSucursal) throws IOException {

        // Aqui busco la sucursal por su ID
        for (int i = 0; i < sucursales.size(); i++) {

            if (sucursales.get(i).getIdSucursal().equals(idSucursal)) {

                // Aqui elimino la sucursal de la lista
                sucursales.remove(i);

                // Aqui guardo la lista actualizada
                repositorioSucursales.guardar(sucursales);

                System.out.println("Sucursal eliminada correctamente.");
                return;
            }
        }

        System.out.println("No se encontro la sucursal.");
    }
}