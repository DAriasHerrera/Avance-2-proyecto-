package com.mycompany.fideburguer.Repositorio;
import com.mycompany.fideburguer.Prototipo.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author DiegoAriasHerrera
 */
public class RepositorioProductos {

    private final File archivo;

    // Aqui defino el archivo donde guardare los productos
    public RepositorioProductos(File archivo) {
        this.archivo = archivo;
    }

    // Aqui recupero los productos almacenados
    public ArrayList<Producto> cargar() throws IOException, ClassNotFoundException {

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream archivoEntrada = new FileInputStream(archivo);
             ObjectInputStream entrada = new ObjectInputStream(archivoEntrada)) {

            ArrayList<Producto> productos =
                    (ArrayList<Producto>) entrada.readObject();

            return productos;
        }
    }

    // Aqui guardo los productos en el archivo
    public void guardar(ArrayList<Producto> productos) throws IOException {

        try (FileOutputStream archivoSalida = new FileOutputStream(archivo);
             ObjectOutputStream salida = new ObjectOutputStream(archivoSalida)) {

            salida.writeObject(productos);
        }
    }
}