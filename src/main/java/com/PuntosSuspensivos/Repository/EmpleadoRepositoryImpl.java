package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.Empleado;
import com.PuntosSuspensivos.util.DataBaseConnection;

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

    };

    @Override
    public void update(Empleado empleado){

    };

    @Override
    public void deleteEmpleado(int id){

    };

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
                System.out.println("ENCONTRADO");
                empleados.add( new Empleado(
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getInt("telefono"),
                        rs.getString("email"),
                        rs.getTimestamp("fecha_registro").toLocalDateTime()
                ));
            }
            return  empleados;

        }catch(SQLException e){

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
                System.out.println("ENCONTRADO");
                return new Empleado(
                    rs.getString("nombre"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getInt("telefono"),
                    rs.getString("email"),
                    rs.getTimestamp("fecha_registro").toLocalDateTime()
                );
            }

        }catch(SQLException e){

        }
        return null;
    }
}
