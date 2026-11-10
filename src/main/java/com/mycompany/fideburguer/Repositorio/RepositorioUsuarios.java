package com.mycompany.fideburguer.Repositorio;
import com.mycompany.fideburguer.Prototipo.Usuario;
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
public class RepositorioUsuarios {

    private final File archivo;

    // Aqui defino el archivo donde guardare los usuarios
    public RepositorioUsuarios(File archivo) {
        this.archivo = archivo;
    }

    // Aqui recupero los usuarios almacenados
    public ArrayList<Usuario> cargar() throws IOException, ClassNotFoundException {

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream archivoEntrada = new FileInputStream(archivo);
             ObjectInputStream entrada = new ObjectInputStream(archivoEntrada)) {

            ArrayList<Usuario> usuarios =
                    (ArrayList<Usuario>) entrada.readObject();

            return usuarios;
        }
    }

    // Aqui guardo los usuarios en el archivo
    public void guardar(ArrayList<Usuario> usuarios) throws IOException {

        try (FileOutputStream archivoSalida = new FileOutputStream(archivo);
             ObjectOutputStream salida = new ObjectOutputStream(archivoSalida)) {

            salida.writeObject(usuarios);
        }
    }
}