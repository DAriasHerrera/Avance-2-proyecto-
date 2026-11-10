package com.mycompany.fideburguer.Repositorio;
import com.mycompany.fideburguer.Prototipo.AsignacionCajero;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
//repositoria para als asignaciones
public class RepositorioAsignaciones {

    private final File archivo;

    public RepositorioAsignaciones(File archivo) {
        this.archivo = archivo;
    }

    // Aqui recupero las asignaciones almacenadas
    public List<AsignacionCajero> cargar()
            throws IOException, ClassNotFoundException {

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream archivoEntrada = new FileInputStream(archivo);
             ObjectInputStream entrada = new ObjectInputStream(archivoEntrada)) {

            Object contenido = entrada.readObject();

            if (!(contenido instanceof List<?>)) {
                throw new IOException("El archivo no contiene una lista de asignaciones.");
            }

            List<?> registros = (List<?>) contenido;
            List<AsignacionCajero> asignaciones = new ArrayList<>();

            for (Object registro : registros) {
                if (!(registro instanceof AsignacionCajero)) {
                    throw new IOException("El registro no es una AsignacionCajero.");
                }

                asignaciones.add((AsignacionCajero) registro);
            }

            return asignaciones;
        }
    }

    // Aqui guardo las asignaciones en el archivo
    public void guardar(List<AsignacionCajero> asignaciones)
            throws IOException {

        File carpeta = archivo.getParentFile();

        if (carpeta != null && !carpeta.exists() && !carpeta.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta.");
        }

        try (FileOutputStream archivoSalida = new FileOutputStream(archivo);
             ObjectOutputStream salida = new ObjectOutputStream(archivoSalida)) {

            salida.writeObject(new ArrayList<>(asignaciones));
        }
    }
}