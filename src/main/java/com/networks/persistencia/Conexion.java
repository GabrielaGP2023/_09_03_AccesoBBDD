package com.networks.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //atributos
    protected Connection miConexion;
    //métodos
    public void abrirConexion() throws SQLException, ClassNotFoundException {
        //1. Registrar el driver

            Class.forName("org.postgresql.Driver");

        //2. Obtener la conexion
        miConexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/northwind3",
                "postgres","postgres");
//        System.out.println("La conexion se ha abierto con exito");
    }

    public void cerrarConexion() throws SQLException {
        miConexion.close();

    }
   //Constructores

    public Conexion() {
    }

    //Setters y getters

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConxion) {
        this.miConexion = miConxion;
    }
}
