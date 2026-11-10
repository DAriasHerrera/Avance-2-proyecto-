package com.mycompany.fideburguer.Repositorio;
import com.mycompany.fideburguer.Prototipo.Combo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCombos {

    private final File archivo;

    public RepositorioCombos(File archivo) {
        this.archivo = archivo;
    }

    // Aqui recupero los combos almacenados
    public List<Combo> cargar() throws IOException, ClassNotFoundException {

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream archivoEntrada = new FileInputStream(archivo);
             ObjectInputStream entrada = new ObjectInputStream(archivoEntrada)) {

            Object contenido = entrada.readObject();

            if (!(contenido instanceof List<?>)) {
                throw new IOException("El archivo no contiene una lista de combos.");
            }

            List<?> registros = (List<?>) contenido;
            List<Combo> combos = new ArrayList<>();

            for (Object registro : registros) {
                if (!(registro instanceof Combo)) {
                    throw new IOException("El registro no es un Combo.");
                }

                combos.add((Combo) registro);
            }

            return combos;
        }
    }

    // Aqui guardo los combos en el archivo
    public void guardar(List<Combo> combos) throws IOException {

        File carpeta = archivo.getParentFile();

        if (carpeta != null && !carpeta.exists() && !carpeta.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta.");
        }

        try (FileOutputStream archivoSalida = new FileOutputStream(archivo);
             ObjectOutputStream salida = new ObjectOutputStream(archivoSalida)) {

            salida.writeObject(new ArrayList<>(combos));
        }
    }
}
