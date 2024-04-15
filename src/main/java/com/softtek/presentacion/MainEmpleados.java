package com.softtek.presentacion;

import com.softtek.persistencia.AccesoEmpleado;

import java.sql.SQLException;

public class MainEmpleados {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //allEmpleados();
        AccesoEmpleado empleado = new AccesoEmpleado();

        int id = 10;
        createEmployee(empleado, id);
        //selectEmployee(empleado, id);
        //updateEmployee(empleado, id,"Madrid, España");
        //deleteEmployee(empleado, id);
    }

    public static void allEmpleados() throws SQLException, ClassNotFoundException {
        AccesoEmpleado productos = new AccesoEmpleado();
        System.out.println(productos.allEmpleados());
    }

    public static void createEmployee(AccesoEmpleado empleado, int id) throws SQLException, ClassNotFoundException {
        int employee_id = id;
        String last_name = "Fuller";
        String first_name = "Andrew";
        String title = "Vice President, Sales";
        String title_of_courtesy = "Dr.";
        String birth_date = "1952-02-19";
        String hire_date = "1992-08-14";
        String address = "908 W. Capital Way";
        String city = "Tacoma";
        String region = "WA";
        String postal_code = "98401";
        String country = "USA";
        String home_phone = "(206) 555-9482";
        String extension = "3457";
        byte photo = 0; //NULL
        String notes = "Notas";
        int reports_to = 0; //NULL
        String photo_path = "http://accweb/emmployees/fuller.bmp";

        empleado.insertEmpleado(employee_id,
                last_name,
                first_name,
                title,
                title_of_courtesy,
                birth_date,
                hire_date,
                address,
                city,
                region,
                postal_code,
                country,
                home_phone,
                extension,
                photo,
                notes,
                reports_to,
                photo_path);

        System.out.println(empleado.selectByID(employee_id));
    }

    public static void selectEmployee(AccesoEmpleado empleado, int id) throws SQLException, ClassNotFoundException {
        System.out.println(empleado.selectByID(id));
    }

    public static void updateEmployee(AccesoEmpleado empleado, int id, String direccion) throws SQLException, ClassNotFoundException {
        empleado.updateAddressByID(id, direccion);
        System.out.println(empleado.selectByID(id));
    }

    public static void deleteEmployee(AccesoEmpleado empleado, int id) throws SQLException, ClassNotFoundException {
        empleado.deleteEmployeeByID(id);
        System.out.println(id);
    }
}
