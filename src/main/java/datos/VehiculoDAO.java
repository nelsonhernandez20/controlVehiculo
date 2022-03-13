package datos;

import dominio.Vehiculo;
import java.sql.*;
import java.util.*;

public class VehiculoDAO {

    private static final String SQL_SELECT = "SELECT * FROM public.vehiculo";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM public.vehiculo WHERE id_vehiculo = ?";
    private static final String SQL_INSERT = "INSERT INTO vehiculo (marca, placa, nombre) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM public.vehiculo WHERE id_vehiculo = ?";
    private static final String SQL_UPDATE = "UPDATE vehiculo SET marca=?, placa=?, nombre=? WHERE id_vehiculo =?";

    public List<Vehiculo> listar() throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vehiculo vehiculo = null;
        List<Vehiculo> vehiculos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVehiculo = rs.getInt("id_vehiculo");
                String marca = rs.getString("marca");
                String placa = rs.getString("placa");
                String nombre = rs.getString("nombre");

                vehiculo = new Vehiculo(idVehiculo, marca, placa, nombre);
                vehiculos.add(vehiculo);

            }
        } catch (SQLException ex) {
            System.out.println("entro en el catch" + rs);
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return vehiculos;
    }

    public Vehiculo encontrar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, vehiculo.getIdVehiculo());
            rs = stmt.executeQuery();
             while (rs.next()) {
                int idVehiculo = rs.getInt("id_vehiculo");
                String marca = rs.getString("marca");
                String placa = rs.getString("placa");
                String nombre = rs.getString("nombre");

                vehiculo = new Vehiculo(idVehiculo, marca, placa, nombre);
                

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vehiculo;
    }

    public int insertar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getPlaca());
            stmt.setString(3, vehiculo.getNombre());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getPlaca());
            stmt.setString(3, vehiculo.getNombre());
            stmt.setInt(4, vehiculo.getIdVehiculo());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vehiculo.getIdVehiculo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public List buscar(String txtBuscar) throws ClassNotFoundException {

        List<Vehiculo> vehiculos = new ArrayList<>();
       // String SQL_buscar = "SELECT * from vehiculo WHERE id_vehiculo like '%" + txtBuscar + "%' or marca like '%" + txtBuscar + "%' or placa like '%" + txtBuscar + "%' or nombre like '%" + txtBuscar + "%'";
        //String SQL_buscar ="SELECT* from vehiculo WHERE nombre = ?"+"or marca = ?"+"or placa=?";
          String SQL_buscar ="SELECT * FROM vehiculo WHERE nombre LIKE '%"+txtBuscar+"%' or marca LIKE '%"+txtBuscar+"%' or placa LIKE '%"+txtBuscar+"%'";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String buscador = "%"+txtBuscar+"%";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_buscar);
//            stmt.setString(1, buscador);
//            stmt.setString(2, buscador);
//            stmt.setString(3, buscador);
            rs = stmt.executeQuery();
            Vehiculo vehiculo = null;
            while(rs.next()){
                
                int idVehiculo = rs.getInt("id_vehiculo");
                String marca = rs.getString("marca");
                String placa = rs.getString("placa");
                String nombre = rs.getString("nombre");

                vehiculo = new Vehiculo(idVehiculo, marca, placa, nombre);
                vehiculos.add(vehiculo);
                
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
        return vehiculos;
    }
}
