
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicio;

import ec.edu.monster.bd.AccesoDB;
import static ec.edu.monster.bd.AccesoDB.getConnection;
import ec.edu.monster.modelo.Cliente;
import ec.edu.monster.modelo.Factura;
import ec.edu.monster.modelo.Localidad;
import ec.edu.monster.modelo.Ticket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonatan
 */
public class TicketService {

    public List<Ticket> leerPartidos() {

        Connection cn = null;

        List<Ticket> lista = new ArrayList<Ticket>();
        String sql = "SELECT p.*, e.ESP_NOMBRE \n"
                + "FROM partido_de_futbol AS p \n"
                + "JOIN estadio AS e ON p.ESP_CODIGO = e.ESP_CODIGO \n"
                + "WHERE p.PAR_FECHA > CURRENT_DATE \n"
                + ";";

        try {
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Ticket tk = new Ticket();
                tk.setNombreEstadio(rs.getString("ESP_NOMBRE"));
                tk.setCodigoPartido(rs.getInt("PAR_CODIGO"));
                tk.setEquipoLocal(rs.getString("PAR_EQUIPO_LOCAL"));
                tk.setEquipoVisita(rs.getString("PAR_EQUIPO_VISITA"));
                tk.setFechaPartido(rs.getDate("PAR_FECHA"));
                tk.setHoraPartido(rs.getString("PAR_HORA"));

                lista.add(tk);
            }

            rs.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
        System.out.println(lista);
        return lista;
    }

    public List<Localidad> leerLocalidades(int codigoPartido) {

        Connection cn = null;
        List<Localidad> lista = new ArrayList<>();
        String sql = "SELECT * \n"
                + " FROM localidad_partido \n"
                + " WHERE PAR_CODIGO = ?;";
        try {

            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, codigoPartido);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Localidad lc = new Localidad();
                lc.setCodigoLocalidad(rs.getInt("LOP_CODIGO"));
                lc.setNombreLocalidad(rs.getString("LOP_NOMBRE"));
                lc.setDisponibilidadLocalidad(rs.getInt("LOP_DISPONIBILIDAD"));
                lc.setPrecioLocalidad(rs.getDouble("LOP_PRECIO"));
                lista.add(lc);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }

        return lista;
    }

    public List<Factura> obtenerReporte(int codigoPartido) {
        Connection cn = null;
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT FAC_LOC_PALCO, FAC_LOC_TRIBUNA, FAC_LOC_GENERAL, FAC_LOC_GENERAL_VISITA, FAC_TOTAL \n"
                + "FROM factura \n"
                + "WHERE PAR_CODIGO = ?;";
        try {
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, codigoPartido);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Factura fc = new Factura();
                fc.setCantPalco(rs.getInt("FAC_LOC_PALCO"));
                fc.setCantTribuna(rs.getInt("FAC_LOC_TRIBUNA"));
                fc.setCantGeneral(rs.getInt("FAC_LOC_GENERAL"));
                fc.setCantGeneralVisita(rs.getInt("FAC_LOC_GENERAL_VISITA"));
                fc.setPrecioTotal(rs.getDouble("FAC_TOTAL"));
                lista.add(fc);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
        return lista;
    }

    public void registrarVenta(String nombreCliente, String cedula, String direccion, int cantPalco, int cantTribuna, int cantGeneral, int cantGeneralVisita, double totalPrecio, int codigoPartido) {
        Connection cn = null;

        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);

            String sql = "INSERT INTO factura (PAR_CODIGO, FAC_NOMBRE_CLIENTE, FAC_CEDULA, FAC_FECHA, FAC_DIRECCION, FAC_LOC_PALCO, FAC_LOC_TRIBUNA, FAC_LOC_GENERAL, FAC_LOC_GENERAL_VISITA, FAC_TOTAL)\n"
                    + "VALUES (?, ?, ?, SYSDATE(), ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, codigoPartido);
            pstm.setString(2, nombreCliente);
            pstm.setString(3, cedula);
            pstm.setString(4, direccion);
            pstm.setInt(5, cantPalco);
            pstm.setInt(6, cantTribuna);
            pstm.setInt(7, cantGeneral);
            pstm.setInt(8, cantGeneralVisita);
            pstm.setDouble(9, totalPrecio);
            pstm.executeUpdate();
            pstm.close();

            if (cantPalco > 0) {
                sql = "UPDATE localidad_partido \n"
                        + "SET LOP_DISPONIBILIDAD = LOP_DISPONIBILIDAD - ? \n"
                        + "WHERE LOP_NOMBRE = 'Palco' AND PAR_CODIGO = ?;";

                pstm = cn.prepareStatement(sql);
                pstm.setInt(1, cantPalco);
                pstm.setInt(2, codigoPartido);
                pstm.executeUpdate();
                pstm.close();
            }

            if (cantTribuna > 0) {
                sql = "UPDATE localidad_partido \n"
                        + "SET LOP_DISPONIBILIDAD = LOP_DISPONIBILIDAD - ? \n"
                        + "WHERE LOP_NOMBRE = 'Tribuna' AND PAR_CODIGO = ?;";

                pstm = cn.prepareStatement(sql);
                pstm.setInt(1, cantTribuna);
                pstm.setInt(2, codigoPartido);
                pstm.executeUpdate();
                pstm.close();
            }

            if (cantGeneral > 0) {
                sql = "UPDATE localidad_partido \n"
                        + "SET LOP_DISPONIBILIDAD = LOP_DISPONIBILIDAD - ? \n"
                        + "WHERE LOP_NOMBRE = 'General' AND PAR_CODIGO = ?;";

                pstm = cn.prepareStatement(sql);
                pstm.setInt(1, cantGeneral);
                pstm.setInt(2, codigoPartido);
                pstm.executeUpdate();
                pstm.close();
            }

            if (cantGeneralVisita > 0) {
                sql = "UPDATE localidad_partido \n"
                        + "SET LOP_DISPONIBILIDAD = LOP_DISPONIBILIDAD - ? \n"
                        + "WHERE LOP_NOMBRE = 'General Visitante' AND PAR_CODIGO = ?;";

                pstm = cn.prepareStatement(sql);
                pstm.setInt(1, cantGeneralVisita);
                pstm.setInt(2, codigoPartido);
                pstm.executeUpdate();
                pstm.close();
            }

            cn.commit();

        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en el proceso Registrar la compra, inténtelo más tarde.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }

    public void registrarUsuario(String usuario, String password, String nombres, String apellidos, String cedula, String direccion) {
        Connection cn = null;

        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);

            String sql = "INSERT INTO clientes (usuario, contrasena, nombres, apellidos, cedula, direccion) \n"
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, encriptarMD5(password));
            pstm.setString(3, nombres);
            pstm.setString(4, apellidos);
            pstm.setString(5, cedula);
            pstm.setString(6, direccion);
            pstm.executeUpdate();
            pstm.close();
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en el proceso Registrar el usuario, inténtelo más tarde.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
        }
    }

    public boolean comprobarUsuario(String username, String password) {
        Connection cn = null;
        boolean existe = false;

        try {
            cn = AccesoDB.getConnection();
            String sql = "SELECT * FROM clientes WHERE usuario = ? AND contrasena = ?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, encriptarMD5(password));
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                existe = true;
            }
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir
            e.printStackTrace();
        } finally {
            // Cerrar la conexión a la base de datos
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return existe;
    }

    private String encriptarMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public Cliente obtenerCliente(String username) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            Connection cn = null;
            cn = getConnection();
            String sql = "SELECT * FROM clientes WHERE usuario = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, username);
            rs = pstm.executeQuery();

            if (rs.next()) {
                // Construye un objeto Cliente con la información obtenida de la base de datos
                cliente = new Cliente(
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("cedula"),
                        rs.getString("direccion")
                );
            }
        } catch (SQLException e) {
            // Manejar la excepción (imprimir o loggear, dependiendo de tus necesidades)
            e.printStackTrace();
        } finally {
            // Cerrar los recursos

        }

        return cliente;
    }
}
