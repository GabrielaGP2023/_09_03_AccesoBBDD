package com.networks.persistencia;

import com.networks.modelo.DetalleOrdenes;
import org.w3c.dom.CDATASection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoDetalleOrdenes extends Conexion{
    public List<DetalleOrdenes> obtenerTodos() throws SQLException, ClassNotFoundException {
        //0. Declarar variables
        Statement sentencia;
        String sql = "select order_id,product_id,unit_price,quantity from order_details;";
        ResultSet rejilla;
        List<DetalleOrdenes> resultado = new ArrayList<>();
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el Statement
        sentencia = miConexion.createStatement();
        rejilla = sentencia.executeQuery(sql);
        //3. Leer en un bucle la informacion
        while (rejilla.next()){
            DetalleOrdenes do1 = new DetalleOrdenes(
                    rejilla.getInt("order_id"),
                    rejilla.getInt("product_id"),
                    rejilla.getDouble("unit_price"),
                    rejilla.getInt("quantity")

            );
            resultado.add(do1);
        }
        //4. Cerrar todos los objetos
        rejilla.close();
        sentencia.close();
        cerrarConexion();
        //5. Devolver la colección
        return resultado;
    }

    public boolean insertar(DetalleOrdenes do1) throws ClassNotFoundException, SQLException {
        //0. Declarar variables
        int resultado = 0;
        PreparedStatement sentencia;
        String sql = """
                insert into order_details
                (order_id,product_id,unit_price,quantity)
                values
                (?,?,?,?);
                """;
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener  el Statement de la conexion
        sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1, do1.getOrdenId());
        sentencia.setInt(2,do1.getProductoId());
        sentencia.setDouble(3,do1.getPrecioUnitario());
        sentencia.setInt(4,do1.getCantidad());

        //3. Ejecutar
        resultado = sentencia.executeUpdate();
        //4. Recorrer el resulset
        sentencia.close();
        cerrarConexion();
        //6. Devolver el DetalleOrdenes
        return resultado>0;
    }

    public boolean cambio(DetalleOrdenes do1) throws ClassNotFoundException, SQLException {
        //0. Declarar variables
        int resultado = 0;
        PreparedStatement sentencia;
        String sql = """
                update order_details
                set unit_price = ?, quantity = ?
                where order_id = ? and product_id = ?
                """;
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener  el Statement de la conexion
        sentencia = miConexion.prepareStatement(sql);
        sentencia.setDouble(1,do1.getPrecioUnitario());
        sentencia.setInt(2,do1.getCantidad());
        sentencia.setInt(3, do1.getOrdenId());
        sentencia.setInt(4,do1.getProductoId());

        //3. Ejecutar
        resultado = sentencia.executeUpdate();
        //4. Recorrer el resulset
        sentencia.close();
        cerrarConexion();
        //6. Devolver el DetalleOrdenes
        return resultado>0;
    }
}
