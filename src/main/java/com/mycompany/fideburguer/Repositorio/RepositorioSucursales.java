package com.mycompany.fideburguer.Repositorio;
import com.mycompany.fideburguer.Prototipo.Sucursal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSucursales {

    private final File archivo;

    public RepositorioSucursales(File archivo) {
        this.archivo = archivo;
    }

    // Aqui recupero las sucursales almacenadas
    public List<Sucursal> cargar() throws IOException, ClassNotFoundException {

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream archivoEntrada = new FileInputStream(archivo);
             ObjectInputStream entrada = new ObjectInputStream(archivoEntrada)) {

            Object contenido = entrada.readObject();

            if (!(contenido instanceof List<?>)) {
                throw new IOException("El archivo no contiene una lista de sucursales.");
            }

            List<?> registros = (List<?>) contenido;
            List<Sucursal> sucursales = new ArrayList<>();

            for (Object registro : registros) {
                if (!(registro instanceof Sucursal)) {
                    throw new IOException("El registro no es una Sucursal.");
                }

                sucursales.add((Sucursal) registro);
            }

            return sucursales;
        }
    }

    // Aqui guardo las sucursales en el archivo
    public void guardar(List<Sucursal> sucursales) throws IOException {

        File carpeta = archivo.getParentFile();

        if (carpeta != null && !carpeta.exists() && !carpeta.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta.");
        }

        try (FileOutputStream archivoSalida = new FileOutputStream(archivo);
             ObjectOutputStream salida = new ObjectOutputStream(archivoSalida)) {

            salida.writeObject(new ArrayList<>(sucursales));
        }
    }
}
