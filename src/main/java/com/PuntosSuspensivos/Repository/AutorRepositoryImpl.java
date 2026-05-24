package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.Autor;
import com.PuntosSuspensivos.Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AutorRepositoryImpl implements AutorRepository{

    @Override
    public void save(Autor autor){
        String query = "INSERT INTO autores (nombre, nacionalidad, fecha_nacimiento, biografia)" +
                "VALUES (?,?,?,?)";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getNombre());
            ps.setDate(3, java.sql.Date.valueOf(autor.getFecha_nacimiento()));
            ps.setString(4, String.valueOf(autor.getBiografia()));

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id_autor, String nombre, String nacionalidad, LocalDate fecha_nacimiento, String biografia){
        String query = "UPDATE autores SET nombre=?, nacionalidad=? ,fecha_nacimiento=?, biografia=? WHERE id_autor=?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setString(1, nombre);
            ps.setString(2, nacionalidad);
            ps.setDate(3, java.sql.Date.valueOf(fecha_nacimiento));
            ps.setString(4, biografia);
            ps.setInt(5, id_autor);

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAutor(int id){
        String query = "DELETE FROM autores WHERE id_autor =?";
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
    public List<Autor> findAll(){
        List<Autor> autores = new ArrayList<>();
        String query = "SELECT * FROM autores";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);

                autores.add( new Autor(
                        id,
                        rs.getString("nombre"),
                        rs.getString("nacionalidad"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getString("biografia")
                ));
            }
            return  autores;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Autor findAutor(int id){
        String query = "SELECT * FROM autores WHERE id_autor = ?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Autor(
                        rs.getInt("id_autor"),
                        rs.getString("nombre"),
                        rs.getString("nacionalidad"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getString("biografia")
                );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
