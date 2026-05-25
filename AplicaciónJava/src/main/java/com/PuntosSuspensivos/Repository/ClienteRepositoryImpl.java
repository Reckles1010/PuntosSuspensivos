package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.Cliente;
import com.PuntosSuspensivos.Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {
    @Override
    public void save(Cliente cliente){
        String query = "INSERT INTO clientes (nombre, fecha_nacimiento, telefono, direccion)" +
                "VALUES (?,?,?,?)";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setString(1, cliente.getNombre());
            ps.setDate(2, java.sql.Date.valueOf(cliente.getFecha_nacimiento()));
            ps.setString(3, String.valueOf(cliente.getTelefono()));
            ps.setString(4, cliente.getDireccion());

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id_cliente, String nombre, LocalDate fecha_nacimiento, int telefono, String direccion){
        String query = "UPDATE clientes SET nombre=?, fecha_nacimiento=?, telefono=?, direccion=?  WHERE id_cliente=?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setString(1, nombre);
            ps.setDate(2, java.sql.Date.valueOf(fecha_nacimiento));
            ps.setInt(3, telefono);
            ps.setString(4, direccion);
            ps.setInt(5, id_cliente);

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCliente(int id){
        String query = "DELETE FROM clientes WHERE id_cliente =?";
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
    public List<Cliente> findAll(){
        List<Cliente> clientes = new ArrayList<>();

        String query = "SELECT * FROM clientes";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);

                clientes.add( new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getInt("telefono"),
                        rs.getString("direccion"),
                        rs.getTimestamp("fecha_creacion").toLocalDateTime()
                ));
            }
            return  clientes;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cliente findCliente(int id){
        String query = "SELECT * FROM clientes WHERE id_cliente = ?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getInt("telefono"),
                        rs.getString("direccion"),
                        rs.getTimestamp("fecha_creacion").toLocalDateTime()
                );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
