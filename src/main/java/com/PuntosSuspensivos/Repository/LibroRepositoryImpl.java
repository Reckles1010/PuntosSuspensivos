package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.Empleado;
import com.PuntosSuspensivos.Entity.Libro;
import com.PuntosSuspensivos.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibroRepositoryImpl implements LibroRepository {
    @Override
    public void save(Libro libro){
        String query = "INSERT INTO libros(id_autor, id_categoria, nombre, isbn, editorial, descripcion, ano_publicacion, precio, stock) VALUES (?,?,?,?,?,?,?,?,?)";

        try (
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ) {

            ps.setInt(1, libro.getId_autor());
            ps.setInt(2, libro.getId_categoria());
            ps.setString(3, libro.getNombre());
            ps.setString(4, libro.getIsbn());
            ps.setString(5, libro.getEditorial());
            ps.setString(6, libro.getDescripcion());
            ps.setInt(7, libro.getAño_publicacion());
            ps.setDouble(8, libro.getPrecio());
            ps.setInt(9, libro.getStock());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id_libro, int id_autor, int id_categoria, String nombre, String isbn, String editorial, String descripcion, int año_publicacion, double precio, int stock){
        String query = "UPDATE libros SET id_autor=?, id_categoria=?, nombre=?, isbn=?, editorial=?, descripcion=?, ano_publicacion=?, precio=?, stock=?  WHERE id_libro=?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id_autor);
            ps.setInt(2, id_categoria);
            ps.setString(3, nombre);
            ps.setString(4, isbn);
            ps.setString(5, editorial);
            ps.setString(6, descripcion);
            ps.setInt(7, año_publicacion);
            ps.setDouble(8, precio);
            ps.setInt(9, stock);
            ps.setInt(10, id_libro);

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLibro(int id){
        String query = "DELETE FROM libros WHERE id_libro =?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Libro> findAll(){
        List<Libro> libros = new ArrayList<>();

        String query = "SELECT * FROM libros";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);

                libros.add( new Libro(
                        id,
                        rs.getInt("id_autor"),
                        rs.getInt("id_categoria"),
                        rs.getString("nombre"),
                        rs.getString("isbn"),
                        rs.getString("editorial"),
                        rs.getString("descripcion"),
                        rs.getInt("ano_publicacion"),
                        rs.getInt("precio"),
                        rs.getInt("stock")
                ));
            }
            return libros;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Libro findLibro(int id){
        String query = "SELECT * FROM libros WHERE id_libro = ?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Libro(
                        rs.getInt("id_libro"),
                        rs.getInt("id_autor"),
                        rs.getInt("id_categoria"),
                        rs.getString("nombre"),
                        rs.getString("isbn"),
                        rs.getString("editorial"),
                        rs.getString("descripcion"),
                        rs.getInt("ano_publicacion"),
                        rs.getInt("precio"),
                        rs.getInt("stock")
                );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
