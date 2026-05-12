package com.PuntosSuspensivos.Frontend;

import com.PuntosSuspensivos.Controller.EmpleadoController;
import com.PuntosSuspensivos.Entity.Empleado;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    Scanner sc=new Scanner(System.in);
    EmpleadoController empleado=new EmpleadoController();

    public void start(){
        while(true) {
            System.out.println("""
                    ==========================
                        Puntos Suspensivos
                    ==========================
                    1. Gestión empleados
                    2. Gestión clientes
                    3. Gestión libros
                    4. Gestión categorías
                    5. Gestión Ventas
                    """);
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> gestionEmpleados();
                case 2 -> gestionClientes();
                case 3 -> gestionLibros();
                case 4 -> gestionCategorias();
                case 5 -> gestionVentas();
            }
        }
    }

    public void gestionEmpleados(){
        System.out.println("""
                1. Ver empleado
                2. Ver todos
                3. Añadir empleado
                4. Modificar empleado
                5. Eliminar empleado
                """);
        int opcion = sc.nextInt();

        switch(opcion){
            case 1 -> verEmpleado();
            case 2 -> verTodosEmpleados();
            case 3 -> añadirEmpleado();
            case 4 -> modificarEmpleado();
            case 5 -> eliminarEmpleado();
        }
    }

    public void verEmpleado(){
        System.out.println("Introduce el Id: ");
        int id=sc.nextInt();

        System.out.println(empleado.findEmpleado(id));
    }

    public void verTodosEmpleados(){
        System.out.println(empleado.findAll());
    }

    public void añadirEmpleado(){
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce la fecha de nacimiento: ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate fecha_nacimiento = LocalDate.parse(sc.nextLine(), formato);

        System.out.print("Introduce el teléfono: ");
        int telefono = sc.nextInt();

        System.out.print("Introduce el email: ");
        String email = sc.nextLine();

        LocalDateTime fecha_registro = LocalDateTime.now();

        empleado.save(new Empleado(nombre, fecha_nacimiento, telefono, email, fecha_registro));
    }

    public void modificarEmpleado(){

    }

    public void eliminarEmpleado(){

    }


    public void gestionClientes(){
        System.out.println("""
                1. Ver cliente
                2. Ver todos
                3. Añadir cliente
                4. Modificar cliente
                5. Eliminar cliente
                """);

        int opcion = sc.nextInt();

        switch(opcion){
            case 1 -> verCliente();
            case 2 -> verTodosClientes();
            case 3 -> añadirCliente();
            case 4 -> modificarCliente();
            case 5 -> eliminarCliente();
            default -> System.out.println("Opción invalida");
        }
    }

    public void verCliente(){

    }

    public void verTodosClientes(){

    }

    public void añadirCliente(){

    }

    public void modificarCliente(){

    }

    public void eliminarCliente(){

    }


    public void gestionLibros() {
        System.out.println("""
                1. Ver libro
                2. Ver todos
                3. Añadir libro
                4. Modificar libro
                5. Eliminar libro
                """);

        int opcion = sc.nextInt();

        switch(opcion){
            case 1 -> verLibro();
            case 2 -> verTodosLibros();
            case 3 -> añadirLibro();
            case 4 -> modificarLibro();
            case 5 -> eliminarLibro();
        }
    }

    public void verLibro(){

    }

    public void verTodosLibros(){

    }

    public void añadirLibro(){

    }

    public void modificarLibro(){

    }

    public void eliminarLibro(){

    }


    public void gestionCategorias() {
        System.out.println("""
                1. Ver categoría
                2. Ver todos
                3. Añadir categoria
                4. Modificar categoría
                5. Eliminar categoria
                """);

        int opcion = sc.nextInt();

        switch(opcion){
            case 1 -> verCategoria();
            case 2 -> verTodasCategorias();
            case 3 -> añadirCategoria();
            case 4 -> modificarCategoria();
            case 5 -> eliminarCategoria();
        }
    }

    public void verCategoria(){

    }

    public void verTodasCategorias(){

    }

    public void añadirCategoria(){

    }

    public void modificarCategoria(){

    }

    public void eliminarCategoria(){

    }


    public void gestionVentas() {
        System.out.println("""
                1. Ver venta
                2. Ver todas las ventas
                3. Realizar venta
                4. Crear ticket
                """);

        int opcion = sc.nextInt();

        switch(opcion){
            case 1 -> verVenta();
            case 2 -> verTodasVentas();
            case 3 -> añadirVenta();
            case 4 -> modificarVenta();
            case 5 -> eliminarVenta();
        }
    }

    public void verVenta(){

    }

    public void verTodasVentas(){

    }

    public void añadirVenta(){

    }

    public void modificarVenta(){

    }

    public void eliminarVenta(){

    }
}
