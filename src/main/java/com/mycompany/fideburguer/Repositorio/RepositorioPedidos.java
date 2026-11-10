package com.mycompany.fideburguer.Repositorio;
import com.mycompany.fideburguer.Prototipo.Pedido;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPedidos {

    private final File archivo;

    public RepositorioPedidos(File archivo) {
        this.archivo = archivo;
    }

    // Aqui recupero los pedidos almacenados
    public List<Pedido> cargar() throws IOException, ClassNotFoundException {

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream archivoEntrada = new FileInputStream(archivo);
             ObjectInputStream entrada = new ObjectInputStream(archivoEntrada)) {

            Object contenido = entrada.readObject();

            if (!(contenido instanceof List<?>)) {
                throw new IOException("El archivo no contiene una lista de pedidos.");
            }

            List<?> registros = (List<?>) contenido;
            List<Pedido> pedidos = new ArrayList<>();

            for (Object registro : registros) {
                if (!(registro instanceof Pedido)) {
                    throw new IOException("El registro no es un Pedido.");
                }

                pedidos.add((Pedido) registro);
            }

            return pedidos;
        }
    }

    // Aqui guardo los pedidos en el archivo
    public void guardar(List<Pedido> pedidos) throws IOException {

        File carpeta = archivo.getParentFile();

        if (carpeta != null && !carpeta.exists() && !carpeta.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta.");
        }

        try (FileOutputStream archivoSalida = new FileOutputStream(archivo);
             ObjectOutputStream salida = new ObjectOutputStream(archivoSalida)) {

            salida.writeObject(new ArrayList<>(pedidos));
        }
    }
}
