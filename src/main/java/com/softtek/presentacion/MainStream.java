package com.softtek.presentacion;

import com.softtek.modelo.Empleado;
import com.softtek.modelo.Producto;
import com.softtek.persistencia.AccesoEmpleado;
import com.softtek.persistencia.AccesoProducto;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class MainStream {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccesoProducto producto = new AccesoProducto();
        AccesoEmpleado empleado = new AccesoEmpleado();

        List<Producto> productos = producto.allProductos();
        List<Empleado> empleados = empleado.allEmpleados();


        ejercicio1(productos);
        ejercicio2(productos);
        ejercicio3(productos);
        ejercicio4(productos);
        ejercicio5(productos);

        ejercicio7(productos);
        ejercicio8(empleados);
    }

    public static void ejercicio1(List<Producto> productos) {
        Predicate<Producto> categoria2 = x -> x.getCategory_id()==2;

        productos.stream()
                .filter(categoria2)
                .forEach(System.out::println);
    }

    public static void ejercicio2(List<Producto> productos) {
        Predicate<Producto> empiezaPorN = x -> x.getProduct_name().startsWith("N");

        productos.stream()
                .filter(empiezaPorN)
                .forEach(System.out::println);
    }

    public static void ejercicio3(List<Producto> productos) {
        productos.stream()
                .sorted(Comparator.comparing(Producto::getProduct_name))
                .forEach(System.out::println);
    }

    public static void ejercicio4(List<Producto> productos) {
        double max = productos.stream()
                .mapToDouble(Producto::getUnit_price)
                .max()
                .orElse(0);

        productos.stream()
                .filter(producto -> producto.getUnit_price() == max)
                .forEach(System.out::println);
    }

    public static void ejercicio5(List<Producto> productos) {
        double promedio = productos.stream()
                .mapToDouble(Producto::getUnit_price)
                .average()
                .orElse(0);

        System.out.println(promedio);
    }

    public static void ejercicio6(List<Producto> productos) {

    }

    public static void ejercicio7(List<Producto> productos) {
        Map<Integer, Long> agruparPorCategoria = productos.stream()
                .collect(groupingBy(Producto::getCategory_id, counting()));

        agruparPorCategoria.forEach((categoria, cantidad) -> System.out.println("Categoria: " + categoria + " - " + cantidad));
    }

    public static void ejercicio8(List<Empleado> empleados) {
        empleados.stream()
                .map(Empleado::getCiudad)
                .distinct()
                .forEach(System.out::println);
    }
}
