package com.PuntosSuspensivos.Frontend;

import com.PuntosSuspensivos.Controller.AutorController;
import com.PuntosSuspensivos.Controller.ClienteController;
import com.PuntosSuspensivos.Controller.EmpleadoController;
import com.PuntosSuspensivos.Entity.Autor;
import com.PuntosSuspensivos.Entity.Cliente;
import com.PuntosSuspensivos.Entity.Empleado;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner sc =new Scanner(System.in);

    EmpleadoController empleado = new EmpleadoController();
    ClienteController cliente = new ClienteController();
    AutorController autor = new AutorController();

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");

    public void start(){
        while(true) {
            System.out.println();
            System.out.println("""
                    ==========================
                        Puntos Suspensivos
                    ==========================
                    1. Gestión empleados
                    2. Gestión clientes
                    3. Gestión autores
                    4. Gestión libros
                    5. Gestión categorías
                    6. Gestión Ventas
                    """);
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> gestionEmpleados();
                case "2" -> gestionClientes();
                case "3" -> gestionAutores();
                case "4" -> gestionLibros();
                case "5" -> gestionCategorias();
                case "6" -> gestionVentas();
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
        String opcion = sc.nextLine();

        switch(opcion){
            case "1" -> verEmpleado();
            case "2" -> verTodosEmpleados();
            case "3" -> añadirEmpleado();
            case "4" -> modificarEmpleado();
            case "5" -> eliminarEmpleado();
        }
    }

    public void verEmpleado(){
        try{
            System.out.println("Introduce el Id: ");
            int id = pedirNumero();

            System.out.println(empleado.findEmpleado(id));
        }catch(InputMismatchException e){
            return;
        }
    }

    public void verTodosEmpleados(){
        try {
            for (Empleado empleado : empleado.findAll()) {
                System.out.println(empleado);
            }
        }catch(InputMismatchException e){
            return;
        }
    }

    public void añadirEmpleado(){
        try {
            sc.nextLine();
            System.out.print("Introduce el nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Introduce la fecha de nacimiento: ");
            LocalDate fecha_nacimiento = LocalDate.parse(sc.nextLine(), formato);

            System.out.print("Introduce el teléfono: ");
            int telefono = pedirNumero();

            System.out.print("Introduce el email: ");
            String email = sc.nextLine();

            LocalDateTime fecha_registro = LocalDateTime.now();

            empleado.save(new Empleado(nombre, fecha_nacimiento, telefono, email, fecha_registro));
        }catch(InputMismatchException e){
            return;
        }
    }

    public void modificarEmpleado(){
        try {
            System.out.println("Que usuarios quieres modificar?");
            int id = pedirNumero();
            System.out.println("Introduce el nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Introduce la fecha de nacimiento: ");
            LocalDate fecha_nacimiento = LocalDate.parse(sc.nextLine(), formato);
            System.out.println("Introduce el telefono: ");
            int telefono = pedirNumero();
            System.out.println("Introduce el email:");
            String email = sc.nextLine();

            empleado.update(id, nombre, fecha_nacimiento, telefono, email);
        }catch(InputMismatchException E){
            return;
        }
    }

    public void eliminarEmpleado(){
        try {
            System.out.println("Que usuario quieres eliminar?");
            int id = pedirNumero();
            empleado.deleteEmpleado(id);
        }catch(InputMismatchException e){
            return;
        }
    }




    public void gestionClientes(){
        try {
            System.out.println("""
                    1. Ver cliente
                    2. Ver todos
                    3. Añadir cliente
                    4. Modificar cliente
                    5. Eliminar cliente
                    """);

            int opcion = pedirNumero();

            switch (opcion) {
                case 1 -> verCliente();
                case 2 -> verTodosClientes();
                case 3 -> añadirCliente();
                case 4 -> modificarCliente();
                case 5 -> eliminarCliente();
                default -> System.out.println("Opción invalida");
            }
        }catch(InputMismatchException e){
            return;
        }
    }

    public void verCliente(){
        System.out.println("Introduce el Id:");
        System.out.println(cliente.findCliente(pedirNumero()));
    }

    public void verTodosClientes(){
        for(Cliente cliente : cliente.findAll()){
            System.out.println(cliente);
        }
    }

    public void añadirCliente(){
        try {
            sc.nextLine();
            System.out.println("Introduce el nombre:");
            String nombre = sc.nextLine();
            System.out.println("Introduce la fecha de nacimiento:");
            LocalDate fecha_nacimiento = LocalDate.parse(sc.nextLine(), formato);
            System.out.println("Introduce el telefono:");
            int telefono = pedirNumero();
            System.out.println("Introduce la direccion:");
            String direccion = sc.nextLine();
            cliente.save(new Cliente(nombre, fecha_nacimiento, telefono, direccion));
        }catch(InputMismatchException e){
            return;
        }
    }

    public void modificarCliente(){
        try {
            System.out.println("Que cliente quieres modificar?");
            int id_cliente = pedirNumero();
            System.out.println("Introduce el nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Introduce la fecha de nacimiento: ");
            LocalDate fecha_nacimiento = LocalDate.parse(sc.nextLine(), formato);
            System.out.println("Introduce el telefono: ");
            int telefono = pedirNumero();
            System.out.println("Introduce el email:");
            String email = sc.nextLine();
            System.out.println("Intorudce la dirección");
            String direccion = sc.nextLine();

            cliente.update(id_cliente, nombre, fecha_nacimiento, telefono, direccion);
        }catch(InputMismatchException E){
            return;
        }
    }

    public void eliminarCliente(){
        System.out.println("Que usuario quieres eliminar?");
        cliente.deleteCliente(pedirNumero());
    }


    public void gestionLibros() {
        System.out.println("""
                1. Ver libro
                2. Ver todos
                3. Añadir libro
                4. Modificar libro
                5. Eliminar libro
                """);

        int opcion = pedirNumero();

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

        int opcion = pedirNumero();

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

        int opcion = pedirNumero();

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


    public void gestionAutores() {
        System.out.println("""
                1. Ver autor
                2. Ver todos los autores
                3. Añadir autor
                4. Modificar autor
                5. Eliminar autor
                """);

        int opcion = pedirNumero();

        switch(opcion){
            case 1 -> verAutor();
            case 2 -> verTodosAutores();
            case 3 -> añadirAutor();
            case 4 -> modificarAutor();
            case 5 -> eliminarAutor();
        }
    }

    public void verAutor(){
        System.out.println("Introduce el Id:");
        int opcion = pedirNumero();
        System.out.println(autor.findAutor(opcion));
    }

    public void verTodosAutores(){
        for(Autor autor : autor.findAll()){
            System.out.println(autor);
        }
    }

    public void añadirAutor(){
        System.out.println("Introduce el nombre:");
        String nombre = sc.next();
        System.out.println("Introduce la nacionalidad");
        String nacionalidad = sc.next();
        System.out.println("Introduce la fecha de nacimeinto");
        LocalDate fecha_nacimiento = LocalDate.parse(sc.next(), formato);
        System.out.println("Introduce la biografia");
        String biografia = sc.next();

        autor.save(new Autor(nombre, nacionalidad, fecha_nacimiento, biografia));
    }

    public void modificarAutor(){
        System.out.println("Que autor quieres modificar?");
        int  id_autor = pedirNumero();
        System.out.println("Introduce el nombre:");
        String nombre = sc.next();
        System.out.println("Introduce la nacionalidad");
        String nacionalidad = sc.next();
        System.out.println("Introduce la fecha de nacimeinto");
        LocalDate fecha_nacimiento = LocalDate.parse(sc.next(), formato);
        System.out.println("Introduce la biografia");
        String biografia = sc.next();

        autor.update(id_autor, nombre, nacionalidad, fecha_nacimiento, biografia);
    }

    public void eliminarAutor(){
        System.out.println("Que autor quieres eliminar?");
        int id_autor = pedirNumero();
        autor.deleteAutor(id_autor);
    }


    private int pedirNumero() {
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }
}
