package com.mycompany.fideburguer.Repositorio;

import com.mycompany.fideburguer.Prototipo.Factura;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RepositorioFacturas {

    private final File archivo;

    public RepositorioFacturas(File archivo) {
        this.archivo = archivo;
    }

    // Aqui recupero las facturas almacenadas
    public List<Factura> cargar() throws IOException, ClassNotFoundException {

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream archivoEntrada = new FileInputStream(archivo);
             ObjectInputStream entrada = new ObjectInputStream(archivoEntrada)) {

            Object contenido = entrada.readObject();

            if (!(contenido instanceof List<?>)) {
                throw new IOException("El archivo no contiene una lista de facturas.");
            }

            List<?> registros = (List<?>) contenido;
            List<Factura> facturas = new ArrayList<>();

            for (Object registro : registros) {
                if (!(registro instanceof Factura)) {
                    throw new IOException("El registro no es una Factura.");
                }

                facturas.add((Factura) registro);
            }

            return facturas;
        }
    }

    // Aqui guardo las facturas en el archivo
    public void guardar(List<Factura> facturas) throws IOException {

        File carpeta = archivo.getParentFile();

        if (carpeta != null && !carpeta.exists() && !carpeta.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta.");
        }

        try (FileOutputStream archivoSalida = new FileOutputStream(archivo);
             ObjectOutputStream salida = new ObjectOutputStream(archivoSalida)) {

            salida.writeObject(new ArrayList<>(facturas));
        }
    }
}