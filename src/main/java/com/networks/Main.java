package com.networks;

import com.networks.modelo.DetalleOrdenes;
import com.networks.persistencia.AccesoDetalleOrdenes;
import com.networks.persistencia.Conexion;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        AccesoDetalleOrdenes ado1 = new AccesoDetalleOrdenes();
        try {
//            System.out.println(ado1.obtenerTodos());
//            System.out.println("Se ha podido dar de alta -> " + ado1.insertar(new DetalleOrdenes(10248,66,10,10)));
            System.out.println("Se ha podido cambiar -> " + ado1.cambio(new DetalleOrdenes(10248,66,10,40)));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}