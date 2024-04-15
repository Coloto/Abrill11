package com.softtek.persistencia;

import com.softtek.modelo.Empleado;
import com.softtek.modelo.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoProducto extends Conexion{
    public Statement sentencia;
    public ResultSet rs;

    public List<Producto> allProductos() throws SQLException, ClassNotFoundException {
        conectar();
        String sql = "SELECT * FROM products;";
        List<Producto> productos = new ArrayList<>();
        sentencia = conn.createStatement();
        rs = sentencia.executeQuery(sql);
        while(rs.next()){
            productos.add(new Producto(rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("category_id"),
                    rs.getInt("unit_price"),
                    rs.getInt("units_in_stock")));
        }
        return productos;
    }
}
