package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.Empleado;
import com.PuntosSuspensivos.Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositoryImpl implements EmpleadoRepository{
    @Override
    public void save(Empleado empleado){
        String query = "INSERT INTO usuarios (nombre, fecha_nacimiento, telefono, email)" +
                "VALUES (?,?,?,?)";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setString(1, empleado.getNombre());
            ps.setDate(2, java.sql.Date.valueOf(empleado.getFecha_nacimiento()));
            ps.setString(3, String.valueOf(empleado.getTelefono()));
            ps.setString(4, empleado.getEmail());

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String nombre, LocalDate fecha_nacimiento, int telefono, String email){
        String query = "UPDATE usuarios SET nombre=?, fecha_nacimiento=?, telefono=?, email=?  WHERE id_usuario=?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setString(1, nombre);
            ps.setDate(2, java.sql.Date.valueOf(fecha_nacimiento));
            ps.setInt(3, telefono);
            ps.setString(4, email);
            ps.setInt(5, id);

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmpleado(int id){
        String query = "DELETE FROM usuarios WHERE id_usuario =?";
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
    public List<Empleado> findAll(){
        List<Empleado> empleados = new ArrayList<>();

        String query = "SELECT * FROM usuarios";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);

                empleados.add( new Empleado(
                        id,
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getInt("telefono"),
                        rs.getString("email"),
                        rs.getTimestamp("fecha_registro").toLocalDateTime()
                ));
            }
            return  empleados;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    };

    @Override
    public Empleado findEmpleado(int id){
        String query = "SELECT * FROM usuarios WHERE id_usuario = ?";

        try(
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Empleado(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getInt("telefono"),
                    rs.getString("email"),
                    rs.getTimestamp("fecha_registro").toLocalDateTime()
                );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
