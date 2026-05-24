package com.PuntosSuspensivos.Frontend;

import com.PuntosSuspensivos.Controller.*;
import com.PuntosSuspensivos.Entity.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc =new Scanner(System.in);

    EmpleadoController empleado = new EmpleadoController();
    ClienteController cliente = new ClienteController();
    AutorController autor = new AutorController();
    CategoriaController categoria = new CategoriaController();
    LibroController libro = new LibroController();

    VentaController venta = new VentaController();
    DetalleVentaController detalle = new DetalleVentaController();

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
                    7. Salir
                    """);
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> gestionEmpleados();
                case "2" -> gestionClientes();
                case "3" -> gestionAutores();
                case "4" -> gestionLibros();
                case "5" -> gestionCategorias();
                case "6" -> gestionVentas();
                case "7" -> System.exit(0);
                default -> System.out.println("Opción invalida");
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
            default -> System.out.println("Opción invalida");
        }
    }

    public void verEmpleado(){
        System.out.println("Introduce el Id: ");
        int id = pedirNumero();

        System.out.println(empleado.findEmpleado(id));
    }

    public void verTodosEmpleados(){
        for (Empleado empleado : empleado.findAll()) {
            System.out.println(empleado);
        }
    }

    public void añadirEmpleado(){
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Introduce la fecha de nacimiento dd/MM/yy: ");
        LocalDate fecha_nacimiento = pedirFecha();

        System.out.println("Introduce el teléfono: ");
        int telefono = pedirNumero();

        System.out.println("Introduce el email: ");
        String email = sc.nextLine();

        LocalDateTime fecha_registro = LocalDateTime.now();

        empleado.save(new Empleado(nombre, fecha_nacimiento, telefono, email, fecha_registro));
    }

    public void modificarEmpleado(){
        System.out.println("Que usuarios quieres modificar?");
        int id = pedirNumero();
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce la fecha de nacimiento dd/MM/yy: ");
        LocalDate fecha_nacimiento = pedirFecha();
        System.out.println("Introduce el telefono: ");
        int telefono = pedirNumero();
        System.out.println("Introduce el email:");
        String email = sc.nextLine();

        empleado.update(id, nombre, fecha_nacimiento, telefono, email);
    }

    public void eliminarEmpleado(){
        System.out.println("Que usuario quieres eliminar?");
        int id = pedirNumero();
        empleado.deleteEmpleado(id);
    }




    public void gestionClientes(){
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
    }

    public void verCliente(){
        System.out.println("Introduce el Id:");
        System.out.println(cliente.findCliente(pedirNumero()));
    }

    public void verTodosClientes(){
        for (Cliente cliente : cliente.findAll()) {
            System.out.println(cliente);
        }
    }

    public void añadirCliente(){
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce la fecha de nacimiento dd/MM/yy: ");
        LocalDate fecha_nacimiento = pedirFecha();
        System.out.println("Introduce el telefono:");
        int telefono = pedirNumero();
        System.out.println("Introduce la direccion:");
        String direccion = sc.nextLine();
        cliente.save(new Cliente(nombre, fecha_nacimiento, telefono, direccion));
    }

    public void modificarCliente(){
        System.out.println("Que cliente quieres modificar?");
        int id_cliente = pedirNumero();
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce la fecha de nacimiento dd/MM/yy: ");
        LocalDate fecha_nacimiento = pedirFecha();
        System.out.println("Introduce el telefono: ");
        int telefono = pedirNumero();
        System.out.println("Introduce el email:");
        String email = sc.nextLine();
        System.out.println("Intorudce la dirección");
        String direccion = sc.nextLine();

        cliente.update(id_cliente, nombre, fecha_nacimiento, telefono, direccion);
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
            default -> System.out.println("Opción invalida");
        }
    }

    public void verLibro(){
        System.out.println("Introduce el Id:");
        int id = pedirNumero();
        
        System.out.println(libro.findLibro(id));
    }

    public void verTodosLibros(){
        for(Libro libro : libro.findAll()){
            System.out.println(libro);
        }
    }

    public void añadirLibro(){
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el Id del autor:  ");
        int id_autor = pedirNumero();
        System.out.println("Introduce el Id de la categoria:  ");
        int id_categoria = pedirNumero();
        System.out.println("Introduce el isbn: ");
        String isbn = sc.nextLine();
        System.out.println("Introduce la editorial: ");
        String editorial = sc.nextLine();
        System.out.println("Introduce la descripcion: ");
        String descripcion = sc.nextLine();
        System.out.println("Introduce el año de publicación: ");
        int añoLanzamiento = pedirNumero();
        System.out.println("Introduce el precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        System.out.println("Introduce el stock: ");
        int stock = pedirNumero();

        libro.save(new Libro(id_autor, id_categoria, nombre, isbn, editorial, descripcion, añoLanzamiento, precio, stock));
    }

    public void modificarLibro(){
        System.out.println("Que libro quieres modificar? ");
        int id_libro = pedirNumero();
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el Id del autor:  ");
        int id_autor = pedirNumero();
        System.out.println("Introduce el Id de la categoria:  ");
        int id_categoria = pedirNumero();
        System.out.println("Introduce el isbn: ");
        String isbn = sc.nextLine();
        System.out.println("Introduce la editorial: ");
        String editorial = sc.nextLine();
        System.out.println("Introduce la descripcion: ");
        String descripcion = sc.nextLine();
        System.out.println("Introduce el año de publicación: ");
        int añoLanzamiento = pedirNumero();
        System.out.println("Introduce el precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        System.out.println("Introduce el stock: ");
        int stock = pedirNumero();

        libro.update(id_libro, id_autor, id_categoria, nombre, isbn, editorial, descripcion, añoLanzamiento, precio, stock);
    }

    public void eliminarLibro(){
        System.out.println("Que usuario quieres eliminar? ");
        int id = pedirNumero();

        libro.deleteLibro(id);
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
            default -> System.out.println("Opción invalida");
        }
    }

    public void verCategoria(){
        System.out.println("Introduce el Id:");
        int id_categoria = pedirNumero();

        System.out.println(categoria.findCategoria(id_categoria));
    }

    public void verTodasCategorias(){
        for(Categoria categoria : categoria.findAll()){
            System.out.println(categoria);
        }
    }

    public void añadirCategoria(){
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();

        categoria.save(new Categoria(nombre));
    }

    public void modificarCategoria() {
        System.out.println("Que categoría quieres modificar)");
        int id = pedirNumero();
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();

        categoria.update(id, nombre);
    }

    public void eliminarCategoria(){
        System.out.println("Que categoría quieres eliminar?");
        int id = pedirNumero();

        categoria.deleteCategoria(id);
    }


    public void gestionVentas() {
        System.out.println("""
                1. Ver venta
                2. Ver todas las ventas
                3. Realizar venta
                4. Modificar venta
                5. Eliminar venta
                6. Crear ticket
                """);

        int opcion = pedirNumero();

        switch(opcion){
            case 1 -> verVenta();
            case 2 -> verTodasVentas();
            case 3 -> añadirVenta();
            case 4 -> modificarVenta();
            case 5 -> eliminarVenta();
            case 6 -> crearTicket();
            default -> System.out.println("Opción invalida");
        }
    }

    public void verVenta(){
        System.out.println("Introduce Id de la venta:");
        int id = pedirNumero();

        System.out.println(venta.findVenta(id));
        System.out.println(detalle.findDetalle(id));
    }

    public void verTodasVentas(){
        for(Venta venta : venta.findAll()){
            System.out.println(venta);
        }
    }

    public void añadirVenta(){
        System.out.println("Introduce ID cliente:");
        int idCliente = pedirNumero();
        System.out.println("Introduce ID empleado:");
        int idEmpleado = pedirNumero();
        System.out.println("Introduce estado de pago:");
        String estado = sc.nextLine();

        Venta ventaN = new Venta(idCliente, idEmpleado, LocalDate.now(), estado);

        List<DetalleVenta> detalles = new ArrayList<>();
        System.out.println("Introduce ID libro:");
        int idLibro = pedirNumero();
        System.out.println("Introduce cantidad:");
        int cantidad = pedirNumero();
        System.out.println("Introduce precio:");
        int precio = pedirNumero();

        detalles.add(new DetalleVenta(idLibro, cantidad, precio));
        venta.save(ventaN, detalles);
    }

    public void modificarVenta(){
        System.out.println("Introduce ID venta:");
        int idVenta = pedirNumero();
        System.out.println("Introduce ID cliente:");
        int idCliente = pedirNumero();
        System.out.println("Introduce ID empleado:");
        int idEmpleado = pedirNumero();

        LocalDate fecha = LocalDate.now();

        System.out.println("Introduce estado de pago:");
        String estado = sc.nextLine();

        venta.update(idVenta, idCliente, idEmpleado, fecha, estado);

        System.out.println("Introduce ID libro:");
        int idLibro = pedirNumero();
        System.out.println("Introduce cantidad:");
        int cantidad = pedirNumero();
        System.out.println("Introduce precio:");
        int precio = pedirNumero();

        detalle.update(idVenta, idLibro, cantidad, precio);
    }

    public void eliminarVenta(){
        System.out.println("Introduce ID de la venta a eliminar:");
        int idVenta = pedirNumero();

        venta.delete(idVenta);
        detalle.delete(idVenta);
    }

    public void crearTicket(){
        System.out.println("Introduce ID de la venta: ");
        int id = pedirNumero();
        venta.crearTicket(id);
    }


    public void gestionAutores(){
        System.out.println("""
                    1. Ver autor
                    2. Ver todos los autores
                    3. Añadir autor
                    4. Modificar autor
                    5. Eliminar autor
                    """);

        int opcion = pedirNumero();

        switch (opcion) {
            case 1 -> verAutor();
            case 2 -> verTodosAutores();
            case 3 -> añadirAutor();
            case 4 -> modificarAutor();
            case 5 -> eliminarAutor();
            default -> System.out.println("Opción invalida");
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
        String nombre = sc.nextLine();
        System.out.println("Introduce la nacionalidad");
        String nacionalidad = sc.nextLine();
        System.out.println("Introduce la fecha de nacimiento dd/MM/yy: ");
        LocalDate fecha_nacimiento = pedirFecha();
        System.out.println("Introduce la biografia");
        String biografia = sc.nextLine();

        autor.save(new Autor(nombre, nacionalidad, fecha_nacimiento, biografia));
    }

    public void modificarAutor(){
        System.out.println("Que autor quieres modificar?");
        int id_autor = pedirNumero();
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce la nacionalidad");
        String nacionalidad = sc.nextLine();
        System.out.println("Introduce la fecha de nacimiento dd/MM/yy: ");
        LocalDate fecha_nacimiento = pedirFecha();
        System.out.println("Introduce la biografia");
        String biografia = sc.nextLine();

        autor.update(id_autor, nombre, nacionalidad, fecha_nacimiento, biografia);
    }

    public void eliminarAutor(){
        System.out.println("Que autor quieres eliminar?");
        int id_autor = pedirNumero();
        autor.deleteAutor(id_autor);
    }


    private int pedirNumero() {
        while(true){
            try{
                return Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Introduce un número");
            }
        }
    }

    private LocalDate pedirFecha() {
        while (true) {
            try {
                return LocalDate.parse(sc.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Formato incorrecto");
            }
        }
    }
}
