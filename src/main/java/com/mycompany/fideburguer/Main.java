package com.mycompany.fideburguer;
import com.mycompany.fideburguer.GUI.VentanaInicioSesion;
import java.io.IOException;

/**
 *
 * @author DiegoAriasHerrera
 */
public class Main {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        // Aqui inicio mi sistema FideBurguer
        SistemaFideBurguer sistema = new SistemaFideBurguer();

        sistema.ejecutar();
        // Aqui abro la ventana de inicio de sesion
        VentanaInicioSesion ventana = new VentanaInicioSesion(sistema);
        ventana.setVisible(true);

    }

}