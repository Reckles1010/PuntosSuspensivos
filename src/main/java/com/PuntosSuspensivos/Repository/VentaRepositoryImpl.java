package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.DetalleVenta;
import com.PuntosSuspensivos.Entity.Venta;
import com.PuntosSuspensivos.Util.DataBaseConnection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VentaRepositoryImpl implements VentaRepository {
    @Override
    public int save(Venta venta) {
        String query = " INSERT INTO ventas(id_cliente, id_usuario, fecha_venta, estado_pago)VALUES (?,?,?,?)";
        try (
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setInt(1, venta.getId_cliente());
            ps.setInt(2, venta.getId_empleado());
            ps.setDate(3, java.sql.Date.valueOf(venta.getFecha_venta()));
            ps.setString(4, venta.getEstado_pago());

            ps.executeUpdate();

            PreparedStatement idMax =connection.prepareStatement("SELECT MAX(id_venta) FROM ventas");
            ResultSet rs = idMax.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(int id, int idCliente, int idEmpleado, LocalDate fechaVenta, String estadoPago) {
        String query = "UPDATE ventas SET id_cliente=?, id_usuario=?, fecha_venta=?, estado_pago=? WHERE id_venta=?";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, idCliente);
            ps.setInt(2, idEmpleado);
            ps.setDate(3, java.sql.Date.valueOf(fechaVenta));
            ps.setString(4, estadoPago);
            ps.setInt(5, id);

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVenta(int id) {
        String query = "DELETE FROM ventas WHERE id_venta=?";
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
    public List<Venta> findAll(){
        List<Venta> ventas = new ArrayList<>();
        String query = "SELECT * FROM ventas";
        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ventas.add(
                        new Venta(
                                rs.getInt("id_venta"),
                                rs.getInt("id_cliente"),
                                rs.getInt("id_usuario"),
                                rs.getDate("fecha_venta").toLocalDate(),
                                rs.getString("estado_pago")
                        )
                );
            }
            return ventas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Venta findVenta(int id) {
        String query = "SELECT * FROM ventas WHERE id_venta=?";
        try(
                Connection connection =DataBaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Venta(
                        rs.getInt("id_venta"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_usuario"),
                        rs.getDate("fecha_venta").toLocalDate(),
                        rs.getString("estado_pago")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void crearTicket(int id) {
        DetalleVentaRepositoryImpl detalleVentaRepositoryImpl = new DetalleVentaRepositoryImpl();
        DetalleVenta detalleVenta = detalleVentaRepositoryImpl.findDetalle(id);
        Venta venta = findVenta(id);

        File carpeta = new File("src/main/java/com/PuntosSuspensivos/Tickets");
        carpeta.mkdirs();

        File fichero = new File(carpeta,"Ticket-"+ UUID.randomUUID()+".txt");

        try(FileWriter fw = new FileWriter(fichero)){
            fw.write("==================================="+"\n");
            fw.write("               TICKET              "+"\n");
            fw.write("==================================="+"\n");
            fw.write("Venta "+venta.getId_venta()+" realizada el "+venta.getFecha_venta()+"\n");
            fw.write("Atendida por "+venta.getId_empleado()+"\n");
            fw.write("Realizada por "+venta.getId_cliente()+"\n");
            fw.write("==================================="+"\n");
            fw.write("Libro comprado: "+detalleVenta.getId_libro()+"\n");
            fw.write("Cantidad: "+detalleVenta.getCantidad()+"\n");
            fw.write("Precio: "+detalleVenta.getPrecio()+"\n");
            fw.write("==================================="+"\n");
            fw.write("TOTAL: "+(detalleVenta.getCantidad()*detalleVenta.getPrecio())+"\n");
            fw.write("==================================="+"\n");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}