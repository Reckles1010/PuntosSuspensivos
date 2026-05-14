package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Repository.DetalleVentaRepository;
import com.PuntosSuspensivos.util.DataBaseConnection;
import com.PuntosSuspensivos.Entity.DetalleVenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaRepositoryImpl implements DetalleVentaRepository {
    @Override
    public void save(DetalleVenta detalle) {
        String query = "INSERT INTO detalle_venta(id_venta, id_libro, cantidad, precio_aplicado) VALUES (?,?,?,?)";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, detalle.getId_venta());
            ps.setInt(2, detalle.getId_libro());
            ps.setInt(3, detalle.getCantidad());
            ps.setInt(4, detalle.getPrecio());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id_venta, int id_libro, int cantidad, int precio) {
        String query = "UPDATE detalle_venta SET cantidad=?, precio_aplicado=? WHERE id_venta=? AND id_libro=?";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, cantidad);
            ps.setInt(2, precio);
            ps.setInt(3, id_venta);
            ps.setInt(4, id_libro);

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<DetalleVenta> findAll(int idVenta) {
        List<DetalleVenta> detalles = new ArrayList<>();

        String query = "SELECT * FROM detalle_venta WHERE id_venta=?";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                detalles.add(
                        new DetalleVenta(
                                rs.getInt("id_venta"),
                                rs.getInt("id_libro"),
                                rs.getInt("cantidad"),
                                rs.getInt("precio_aplicado")
                        )
                );
            }
            return detalles;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DetalleVenta findDetalle(int idVenta){
        String query = "SELECT * FROM detalle_venta WHERE id_venta=?";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new DetalleVenta(
                        rs.getInt("id_detalle"),
                        rs.getInt("id_venta"),
                        rs.getInt("id_libro"),
                        rs.getInt("cantidad"),
                        rs.getInt("precio_aplicado")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteVenta(int idVenta) {
        String query="DELETE FROM detalle_venta WHERE id_venta=?";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, idVenta);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}