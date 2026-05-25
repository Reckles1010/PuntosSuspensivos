package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.Categoria;
import com.PuntosSuspensivos.Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryImpl implements CategoriaRepository{
    public void save(Categoria categoria){
        String query = "INSERT INTO categorias (nombre_categoria)" +
                "VALUES (?)";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setString(1, categoria.getNombre());

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    };

    public void update(int id, String nombre){
        String query = "UPDATE categorias SET nombre_categoria=? WHERE id_categoria=?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setString(1, nombre);
            ps.setInt(2, id);

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    };

    public void deleteCategoria(int id){
        String query = "DELETE FROM categorias WHERE id_categoria =?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    };

    public List<Categoria> findAll(){
        List<Categoria> categorias = new ArrayList<>();

        String query = "SELECT * FROM categorias";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);

                categorias.add( new Categoria(
                        id,
                        rs.getString("nombre_categoria")
                ));
            }
            return  categorias;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Categoria findCategoria(int id){
        String query = "SELECT * FROM categorias WHERE id_categoria = ?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre_categoria")
                );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    };
}
